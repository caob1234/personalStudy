package com.smart.basic.complicating;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                print(this+" "+"thinking");
                pause();
                print(this+" "+"grabbing right");
                right.take();
                print(this+" "+"grabbing left");
                left.take();
                pause();
                right.drop();
                left.drop();
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
