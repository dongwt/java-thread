package com.dongwt.thread.entity;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @author: dongwt
 * @create: 2017-06-02 15:48
 **/
public class PreLoader {

    private FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
        public String call() throws Exception {
            Thread.sleep(1000*5);
            if(true){
                throw new NullPointerException();
            }
            return "hello world!";
        }
    });

    public void start(){
        Thread thread = new Thread(future);
        thread.start();
    }

    public String get(){
        String result = "";
        try {
            result = future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return  result;
        }
    }

}
