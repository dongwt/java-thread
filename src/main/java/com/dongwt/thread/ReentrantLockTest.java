package com.dongwt.thread;

import com.dongwt.thread.entity.BoundedBuffer;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author: dongwt
 * @create: 2017-06-05 18:09
 **/
public class ReentrantLockTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i=0; i<10; i++){
            executor.execute(new Runnable() {
                public void run() {
                    BoundedBuffer boundedBuffer = new BoundedBuffer();
                    try {
                        Thread.sleep(1000*3);
                        boundedBuffer.put(Thread.currentThread().getName() + "A");
                        Thread.sleep(1000*3);
                        System.out.println(Thread.currentThread().getName() + boundedBuffer.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executor.shutdown();
    }


}
