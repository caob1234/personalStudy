package com.smart.basic.complicating;

public class TestRunnable implements Runnable {
    public TestRunnable() {
        System.out.println("Start!!!!!!");
    }

    @Override
    public void run() {
        for (int i=0;i<3;i++){
            System.out.println("This is run method inner "+i);
            Thread.yield();
        }
    }
}
