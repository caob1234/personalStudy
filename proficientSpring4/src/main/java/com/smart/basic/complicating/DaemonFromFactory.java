package com.smart.basic.complicating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try{
            while (true){
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread()+" "+this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)throws Exception{
        ExecutorService service = Executors.newCachedThreadPool(
                new DaemonThreadFactory());
        for (int i=0;i<10;i++){
            service.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.SECONDS.sleep(6);
    }
}
