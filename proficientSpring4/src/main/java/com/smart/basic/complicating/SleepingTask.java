package com.smart.basic.complicating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try {
            while(countDown-->0){
                System.out.print(status());
//                Thread.sleep(100);
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            service.execute(new SleepingTask());
        }
        service.shutdown();
    }
}
