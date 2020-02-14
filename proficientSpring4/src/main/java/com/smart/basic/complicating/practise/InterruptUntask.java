package com.smart.basic.complicating.practise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class Untask{
    public void sleepF(){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            print("sleepF() interrupted");
        }
        print("Exiting sleepF()");
    }
}
public class InterruptUntask implements Runnable{
    private Untask untask;

    public InterruptUntask(Untask untask) {
        this.untask = untask;
    }

    @Override
    public void run() {
        untask.sleepF();
    }
    public static void main(String[] args)throws Exception{
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new InterruptUntask(new Untask()));
        TimeUnit.SECONDS.sleep(3);
        executorService.shutdownNow();
    }
}
