package com.dongwt.thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dongwt on 2017/9/11.
 */
public class ExecutorTest {

    private static List<Runnable> getRunnable(){
        List<Runnable> runnableList = new ArrayList();

        runnableList.add(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        runnableList.add(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        runnableList.add(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        return runnableList;
    };


    public static  void main(String[] args){
        List<Runnable> runnables = getRunnable();
        int count = runnables.size();
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        for(int i = 0; i<count; i++){
            executorService.execute(runnables.get(i));
        }
        executorService.shutdown();
        System.out.println("executor shutdown");
    }
}
