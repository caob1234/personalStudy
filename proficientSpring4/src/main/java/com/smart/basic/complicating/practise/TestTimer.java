package com.smart.basic.complicating.practise;

import java.util.Timer;
import java.util.TimerTask;
class exTimerTask extends TimerTask{
    private int anInt;
    public exTimerTask(int i) {
        this.anInt=i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-"+anInt);
    }
}
public class TestTimer {
    public static void main(String[] args){
        for (int i=0;i<10;i++){
            new Timer().schedule(new exTimerTask(i),5000+i*1000);
        }
    }
}
