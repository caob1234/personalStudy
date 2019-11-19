package com.smart.basic;

public class MoreBasicThreads {
    public static void main(String[] args){
        for (int i=0;i<5;i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
//        int i=9;
//        System.out.println(i/10);
    }
}
