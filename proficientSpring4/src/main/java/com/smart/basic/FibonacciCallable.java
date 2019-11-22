package com.smart.basic;

import java.util.concurrent.Callable;

public class FibonacciCallable implements Callable<Integer> {
    private int n;

    public FibonacciCallable(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
        int total = 0;
        Fibonacci fib = new Fibonacci();
        for (int i=0;i<n;i++){
            total += fib.next();
        }
        return total;
    }
}
