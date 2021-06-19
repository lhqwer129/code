package com.pattern.pattern.singleton;

/**
 * Description: 保证在任何情况下都只有一个实例
 *
 * @author lihui
 * @time 2021/5/17 8:45 下午
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    // 懒汉式 线程安全
    public synchronized Singleton getInstance () {
        if (singleton == null) {
            return new Singleton();
        }
        return singleton;
    }



}
