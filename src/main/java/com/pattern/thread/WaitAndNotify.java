package com.pattern.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: wait() and notify()
 *
 * https://blog.csdn.net/fuyuwei2015/article/details/83592126
 *
 * @author lihui
 * @time 2021/6/7 9:16 下午
 */
public class WaitAndNotify {

    private volatile static List<String> list = new ArrayList();

    public void add(){
        list.add("bjsxt");
    }
    public int size(){
        return list.size();
    }

    public static void main1(String[] args) {

        final WaitAndNotify list1 = new WaitAndNotify();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i <10; i++){
                        list1.add();
                        System.out.println(Thread.currentThread() + "当前线程：" + Thread.currentThread().getName() + "添加了一个元素..");
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(list1.size() == 5){
                        System.out.println(Thread.currentThread() + "当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止..");
                        throw new RuntimeException();
                    }
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }

    public static void main2(String[] args) {

        final WaitAndNotify list2 = new WaitAndNotify();
        final Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        System.out.println("t1启动..");
                        for(int i = 0; i <10; i++){
                            list2.add();
                            System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素..");
                            Thread.sleep(500);
                            if(list2.size() == 5){
                                System.out.println("已经发出通知..");
                                lock.notify();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("t2启动..");
                    if(list2.size() != 5){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "收到通知线程停止..");
                    throw new RuntimeException();
                }
            }
        }, "t2");
        t2.start();
        t1.start();

    }

}
