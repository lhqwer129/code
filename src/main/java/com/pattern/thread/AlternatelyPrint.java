package com.pattern.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/6/9 7:09 下午
 */
public class AlternatelyPrint {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        Object lock = new Object();
        int[] data1 = {1, 3, 5, 7};
        int[] data2 = {2, 4, 6, 8};


        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < data1.length; i++) {
                    // 起始先打印一个字母
                    System.out.println(data1[i]);
                    // 打印完唤醒t2打印数字
                    LockSupport.unpark(t2);
                    // 自己阻塞，等待唤醒
                    LockSupport.park();
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < data2.length; i++) {
                    // 起始先阻塞等待
                    LockSupport.park();
                    // 被唤醒后打印数字
                    System.out.println(data2[i]);
                    // 唤醒t1
                    LockSupport.unpark(t1);
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main1(String[] args) {
        Object lock = new Object();
        int[] data1 = {1, 3, 5, 7};
        int[] data2 = {2, 4, 6, 8};

        Thread t1 = null;
        Thread t2 = null;

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < data1.length; i++){
                    synchronized (lock) {
                        System.out.println(data1[i]);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < data2.length;  i++){
                    synchronized(lock) {
                        System.out.println(data2[i]);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

}
