package com.smart.basic.complicating.practise;


import com.smart.basic.complicating.Chopstick;
import com.smart.basic.complicating.practise.Bin;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

public class PhilosopherByQueue implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private Bin bin;
    private final int id;
    private final int ponderFactor;

    public PhilosopherByQueue(Chopstick left, Chopstick right, int id, int ponderFactor,Bin bin) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
        this.bin=bin;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Chopstick chopstick1,chopstick2;
                print(this+" "+"thinking");
                pause();
                print(this+" "+"grabbing right");
                if (!right.isTaken()){
                    bin.put(right);
                    right.setTaken(true);
                    chopstick1=null;
                }else {
                    chopstick1=bin.take();
                }
                print(this+" "+"grabbing left");
                if (!left.isTaken()){
                    bin.put(left);
                    left.setTaken(true);
                    chopstick2=null;
                }else {
                    chopstick2=bin.take();
                }
                pause();
                if (chopstick1!=null){
                    bin.put(chopstick1);
                }
                if (chopstick2!=null){
                    bin.put(chopstick2);
                }
            }
        }catch (InterruptedException e){
            print(this+" "+"exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" + "id=" + id + '}';
    }

    private Random random=new Random(47);
    private void pause() throws InterruptedException{
        if (ponderFactor==0)return;
        TimeUnit.MILLISECONDS.sleep(
                random.nextInt(ponderFactor*250)
        );
    }
}