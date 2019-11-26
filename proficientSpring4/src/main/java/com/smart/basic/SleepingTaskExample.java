package com.smart.basic;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTaskExample implements Runnable {
    private int nums = 10;
    @Override
    public void run() {
        while (nums-- > 0) {
            try {
                int n= new Random().nextInt(10);
                TimeUnit.SECONDS.sleep(n);
                System.out.print(n+" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            exec.execute(new SleepingTaskExample());
        }
        exec.shutdown();
    }
}

