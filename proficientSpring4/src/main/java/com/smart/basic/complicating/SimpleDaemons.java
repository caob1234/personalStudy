package com.smart.basic.complicating;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {
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
        for (int i=0;i<10;i++){
            Thread t = new Thread(new SimpleDaemons());
            t.setDaemon(true);
            t.start();
        }
        System.out.println("All daemons started");
        TimeUnit.SECONDS.sleep(5);
    }
}
