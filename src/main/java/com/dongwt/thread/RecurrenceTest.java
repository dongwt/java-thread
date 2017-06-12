package com.dongwt.thread;

/** x的n次方
 * Created by dongwt on 2017/6/9.
 */
public class RecurrenceTest {

    public static void main(String[] args) {
        System.out.println(recurrence(2,4));
    }

    public static int recurrence(int x,int n){
        if(n>1){
            return recurrence(x,n-1) * x;
        }else{
            return x;
        }
    }

}
