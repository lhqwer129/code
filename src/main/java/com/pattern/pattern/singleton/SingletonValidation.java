package com.pattern.pattern.singleton;

/**
 * Description: 双重锁校验，线程安全
 *
 * @author lihui
 * @time 2021/6/9 7:48 下午
 */
public class SingletonValidation {

    public volatile static SingletonValidation singletonValidation;

    public SingletonValidation() {
    }

    public SingletonValidation getInstance() {
        if (singletonValidation == null) {
            synchronized(this) {
                if (singletonValidation == null) {
                    singletonValidation = new SingletonValidation();
                }
            }
        }
        return singletonValidation;
    }
}
