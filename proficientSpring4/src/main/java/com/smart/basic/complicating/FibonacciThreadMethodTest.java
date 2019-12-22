package com.smart.basic.complicating;

import java.util.concurrent.ExecutionException;

public class FibonacciThreadMethodTest {
    public static void main(String[] args){
        for (int i=0;i<10;i++){
            try {
                System.out.print(new FibonacciThreadMethod().runTask(i).get()+" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
