package com.smart.basic.complicating;

import java.util.concurrent.TimeUnit;

public class SimpleThread extends Thread{
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread(){
        super(Integer.toString(++threadCount));
        start();
    }
    public String toString(){
        return "#"+getName()+"("+countDown+").";
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }
    public static void main(String[] args){
        for (int i=0;i<5;i++){
            Thread  t=new Thread(new SimpleThread());
            t.setDaemon(true);
            t.start();
        }
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
