package com.pattern.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.exceptions.JedisNoScriptException;
import redis.clients.jedis.params.SetParams;

/**
 * Description:
 * https://blog.csdn.net/qq_20597727/article/details/85235602
 * https://www.jianshu.com/p/eac5480921e7
 * https://juejin.cn/post/6844903849115779080
 *
 * 分布式锁的重要特性
 * 1、互斥性，一个锁只能被一个线程持有
 * 2、高可用，在锁超时的情况下可以自动释放锁
 *
 * 其它特征：可重入性（一个线程可以重复获取锁），非阻塞（获取锁失败即返回），安全性(锁只能被其持有者删除)
 *
 * 分布式锁几种方式:
 * 1、setnx + expire
 *
 * @author lihui
 * @time 2021/6/1 5:02 下午
 */
public class RedisDistributeLock {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 注意初始化jedisCluster
     */
    private volatile JedisCluster jedisCluster;

    private RedisTemplate<String, String> redisTemplate;

    private static final Long UNLOCK_SUCCESS_CODE = 1L;

    /**
     * lua脚本：判断锁住值是否为当前线程持有，是的话解锁，不是的话解锁失败
     * 保证操作原子性
     */
    @SuppressWarnings("checkstyle:OperatorWrap")
    private static final String DISTRIBUTE_LOCK_SCRIPT_UNLOCK_VAL = "if" +
            " redis.call('get', KEYS[1]) == ARGV[1]" +
            " then" +
            " return redis.call('del', KEYS[1])" +
            " else" +
            " return 0" +
            " end";

    private static final String LOCK_SUCCESS_CODE = "ok";

    private volatile String unlockSha1 = "";

    //todo 可使用lua脚本实现
    /**
     * 只尝试一次获取锁，快速失败
     *
     * EX seconds -- Set the specified expire time, in seconds.
     * PX milliseconds -- Set the specified expire time, in milliseconds.
     * NX -- Only set the key if it does not already exist.
     * XX -- Only set the key if it already exist.
     *
     * NX,PX一起执行保证操作原子性
     *
     * @param lockKey key
     * @param lockVal val
     * @param expiryTime 过期时间，millis
     * @return boolean
     */
    public boolean tryLock (String lockKey, String lockVal, long expiryTime) {
        SetParams setParams = new SetParams();
        setParams.nx();
        setParams.px(expiryTime);
        String result = jedisCluster.set(lockKey, lockVal, setParams);
        return LOCK_SUCCESS_CODE.equals(result);
    }

    /**
     * 依赖RedisTemplate类中setIfAbsent实现分布式锁
     *
     * @param lockKey key
     * @param lockVal value
     * @param expiryTime 过期时间，millis
     * @return @return {@literal null} when used in pipeline / transaction.
     */
    public boolean tryLockByRedisTemplate (String lockKey, String lockVal, long expiryTime) {

        return redisTemplate.opsForValue().setIfAbsent(lockKey, lockVal, expiryTime, TimeUnit.MILLISECONDS);
    }


    /**
     * 根据loopTryTime循环重试获取锁
     * 可重入
     *
     * @param lockKey     锁key
     * @param lockVal     锁值，用于解锁校验
     * @param expiryTime  锁过期时间 millis
     * @param loopTryTime 获取失败时，循环重试获取锁的时长 millis
     * @return 是否获得锁
     */
    public boolean tryLock (String lockKey, String lockVal, long expiryTime, long loopTryTime) {
        long endTime = System.currentTimeMillis() + loopTryTime;
        while(System.currentTimeMillis() < endTime) {
            if (tryLock(lockKey, lockVal, expiryTime)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 设置重试次数以及间隔时间
     *
     * @param lockKey    锁key
     * @param lockVal    锁值，用于解锁校验
     * @param expiryTime 锁过期时间
     * @param retryTimes 重试次数
     * @param setpTime   每次重试间隔 mills
     * @return 是否获得锁
     */
    public boolean tryLock(String lockKey, String lockVal, long expiryTime, int retryTimes, long setpTime) {
        while (retryTimes > 0) {
            if (tryLock(lockKey, lockVal, expiryTime)) {
                return true;
            }
            retryTimes--;
            try {
                Thread.sleep(setpTime);
            } catch (InterruptedException e) {
                logger.error("get distribute lock error:" + e);
            }
        }
        return false;
    }

    /**
     * 释放分布式锁，释放失败最可能是业务执行时间长于lockKey过期时间，应当结合业务场景调整过期时间
     *
     * 释放锁时需要验证该线程是否是锁的持有者，验证方式是每个线程执行时都有他自己的lockKey和lockVal(lockVal必须保持不同，一般会根据线程生成其独有的UUID)，
     * 在释放所时首先校验redis.call('get', KEYS[1]) == ARGV[1]，为true才执行后续操作，否则锁容易出现误删的情况。
     *
     * @param lockKey 锁key
     * @param lockVal 锁值
     * @return 是否释放成功
     */
    public boolean tryUnLock(String lockKey, String lockVal){
        List<String> keys = new ArrayList<>();
        keys.add(lockKey);
        List<String> argv = new ArrayList<>();
        argv.add(lockVal);
        try {
            Object result = jedisCluster.evalsha(unlockSha1, keys, argv);
            return UNLOCK_SUCCESS_CODE.equals(result);
        }catch (JedisNoScriptException e){
            //没有脚本缓存时，重新发送脚本并缓存
            //根据lockkey计算slot，在对应redis节点重新缓存一份脚本数据
            logger.info("try to store script......");
            storeScript(lockKey);
            //重试获取
            Object result = jedisCluster.evalsha(unlockSha1, keys, argv);
            return UNLOCK_SUCCESS_CODE.equals(result);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 由于使用redis集群，因此每个节点都需要各自缓存一份脚本数据
     * @param slotKey 用来定位对应的slot的slotKey
     */
    public void storeScript(String slotKey){
        if (StringUtils.isEmpty(unlockSha1) || !jedisCluster.scriptExists(unlockSha1, slotKey)){
            //redis支持脚本缓存，返回哈希码，后续可以继续用来调用脚本
            unlockSha1 = jedisCluster.scriptLoad(DISTRIBUTE_LOCK_SCRIPT_UNLOCK_VAL, slotKey);
        }
    }













}
