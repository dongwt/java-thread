package com.dongwt.thread;

import com.dongwt.thread.entity.PreLoader;

/**
 * @Description:
 * @author: dongwt
 * @create: 2017-06-02 15:47
 **/
public class FutureTaskTest {

    public static void main(String[] args) {
        PreLoader preLoader = new PreLoader();
        preLoader.start();
        String result = preLoader.get();
        System.out.println("result: " + result);
    }
}
