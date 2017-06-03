package com.dongwt.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author: dongwt
 * @create: 2017-06-03 17:20
 **/
public class ExchangerTest {

    private static final Exchanger<String> exchanger = new Exchanger<String>();

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        executorService.execute(new Runnable() {
            public void run() {
                String A = "银行流水A";// A录入银行流水数据
                try {
                    String B = exchanger.exchange(A);
                    System.out.println(Thread.currentThread().getName() + " A:" + A + " B:" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                String B = "银行流水B";// B录入银行流水数据
                try {
                    String A = exchanger.exchange(B);
                    System.out.println(Thread.currentThread().getName() + " A:" + A + " B:" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        executorService.shutdown();
    }

}
