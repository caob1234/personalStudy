package com.smart.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FibonacciThreadTest {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName()+"-------------");
//        Thread thread = new Thread(new FibonacciThread()) ;
//        thread.start();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i=0;i<4;i++){
            service.execute(new FibonacciThread(10));
        }
        service.shutdown();
    }
}
