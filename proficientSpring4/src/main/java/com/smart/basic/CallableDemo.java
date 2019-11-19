package com.smart.basic;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (int i=0;i<10;i++){
            futures.add(executorService.submit(new TaskWithResult(i)));
        }
        System.out.println("My name is CallableDemo!");
        for (Future<String> fs:futures) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }

    }
}
