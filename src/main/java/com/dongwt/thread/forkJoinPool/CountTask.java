package com.dongwt.thread.forkJoinPool;

import java.util.concurrent.RecursiveTask;

/**
 * 1+2+3+4
 * Created by dongwt on 2017/9/12.
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final Integer THRESHOLD = 2;

    private Integer start;

    private Integer end;

    public CountTask() {
    }

    public CountTask(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        Integer sum = 0;
        if ((end - start) / 2 <= THRESHOLD) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }else{
            Integer middle = (end-start)/2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            sum = leftTask.join() + rightTask.join();
        }
        return sum;
    }
}
