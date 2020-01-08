package com.smart.basic.complicating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }
    public static void main(String[] args){
        try {
            ExecutorService service= Executors.newCachedThreadPool();
            service.execute(new ExceptionThread());
            service.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
