package com.smart.basic.complicating;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount=0;
    private final int id =taskCount++;
    private int execuNumbers=0;

    public LiftOff(){};
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while(countDown-->0){
//            if (status().contains("LiftOff!")){
//                System.out.print(status()+"\n");
//            }else {
                System.out.print(status());
                Thread.yield();
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public String status() {
        return Thread.currentThread().getName()
                +"#"+id+"("+(countDown>0?countDown:"LiftOff!")+"),";
    }

    private BlockingDeque<Integer> count;

    private synchronized void print(String str){
        if (count.isEmpty()){
            count.push(0);
        }
        count.add(count.getLast()+1);
//        if (str.contains("LiftOff!")){
//            System.out.print("\n");
//        }
//        System.out.print(str);
        System.out.print(count.getLast()+" ");
    }
}
