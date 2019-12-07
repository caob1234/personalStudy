package com.smart.basic.complicating;

public class BasicThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new LiftOff());
        t.start();
        Thread.sleep(500);
        System.out.println("Waiting for LiftOff!");
    }
}
