package com.pattern.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor pool =
                new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<Runnable>(210000), Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 100; i ++) {
            int finalI = i;
            pool.execute(() -> {
                System.out.println(finalI);
            });
        }
    }
}
