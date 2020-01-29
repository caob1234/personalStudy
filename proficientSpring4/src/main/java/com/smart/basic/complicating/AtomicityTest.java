package com.smart.basic.complicating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i=0;
    public synchronized int getValue(){
//        System.out.println(Thread.currentThread().getName());
        return i;
    }
    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName());
        while (true)
            evenIncrement();
    }

    private synchronized void evenIncrement() {
//        System.out.println(Thread.currentThread().getName());
        i++;
        i++;
    }
    public static void main(String[] args){
        System.out.println("main method start");
        ExecutorService service= Executors.newCachedThreadPool();
        AtomicityTest atomicityTest=new AtomicityTest();
        service.execute(atomicityTest);
        while (true){
            int v=atomicityTest.getValue();
            if (v%2!=0){
                System.out.println(v);
                System.exit(0);
            }
        }
    }
}
