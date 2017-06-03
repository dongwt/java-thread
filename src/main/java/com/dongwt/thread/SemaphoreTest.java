package com.dongwt.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @author: dongwt
 * @create: 2017-06-02 16:12
 **/
public class SemaphoreTest {

    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i< 100; i++){
            final int NO = i;
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("NO:" + NO);
                        Thread.sleep(1000*5);
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();

    }
}
