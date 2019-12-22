package com.smart.basic.complicating;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class InnerCallable implements Callable<Integer>{
    private int n;
    public InnerCallable(int n) {
        this.n=n;
    }

    @Override
    public Integer call() throws Exception {
        int total = 0;
        Fibonacci fib = new Fibonacci();
        for (int i=0;i<n;i++){
            total += fib.next();
        }
        return total;
    }
}
public class FibonacciThreadMethod {
    private ExecutorService executorService;
    public Future<Integer> runTask(int n){
        executorService= Executors.newCachedThreadPool();
        return executorService.submit(new InnerCallable(n));
    }
}
