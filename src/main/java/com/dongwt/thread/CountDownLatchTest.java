package com.dongwt.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @author: dongwt
 * @create: 2017-06-02 11:32
 **/
public class CountDownLatchTest {

    private static List<String> names = new ArrayList<String>();

    static {
        names.add("孙悟空");
        names.add("猪八戒");
        names.add("沙和尚");
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 3;
        CountDownLatch startSignal= new CountDownLatch(1);
        final CountDownLatch endSignal= new CountDownLatch(num);


        for(int i = 0; i<num; i++){
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "说: 师傅，等等我。");
                    endSignal.countDown();
                }
            },names.get(i)).start();
        }

        startSignal.countDown();
        endSignal.await();

        System.out.println("唐僧说：我们取经回来啦!");
    }
}
