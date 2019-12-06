package com.smart.basic.complicating;

public class FibonacciThread implements Runnable {
    private int n=5;
    public FibonacciThread(int n) {
        this.n = n;
    }

    public FibonacciThread() {
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        Fibonacci fib = new Fibonacci();
        for (int i=0;i<n;i++){
            System.out.print(fib.next()+" ");
        }
    }
}
