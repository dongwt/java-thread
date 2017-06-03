package com.dongwt.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: CountDownLatch的计数器只能使用一次。而CyclicBarrier的计数器可以使用reset() 方法重置。
 * 所以CyclicBarrier能处理更为复杂的业务场景，比如 如果计算发生错误，可以重置计数器，并让线程们重新执行一次。
 * @author: dongwt
 * @create: 2017-06-03 16:36
 **/
public class CyclicBarrierTest {

    private static CyclicBarrier c = new CyclicBarrier(2, new Runnable() {
        public void run() {
            System.out.println(3);
        }
    });

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(2);


    }
}
