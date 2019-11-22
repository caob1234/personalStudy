package com.smart.basic;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> futures = new ArrayList<>();
        for (int i=0;i<10;i++){
            Future<Integer> f1 =service.submit(new FibonacciCallable(i+8));
            futures.add(f1);
//            System.out.println(f1.get());
        }
        for (Future<Integer> f:futures) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                service.shutdown();
            }
        }
        System.out.println("----------FibonacciCallableTest end---------");
    }
}
