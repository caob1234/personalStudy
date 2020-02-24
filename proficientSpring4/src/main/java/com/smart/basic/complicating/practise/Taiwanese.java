package com.smart.basic.complicating.practise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static net.mindview.util.Print.print;

/**
 * Record Taiwanese conduct in epidemic situation,Coronavirus
 */
class Mask {
    private volatile int num;

    public synchronized int getNum() {
        return num;
    }

    public Mask(int num) {
        this.num = num;
    }

    public synchronized void increment(int i){
        while (i-->0){
            num++;
        }
    }
    public synchronized void decrement(){
        num--;
    }
    @Override
    public String toString() {
        return "Mask{" + "num=" + num + '}';
    }
}

class Producer implements Runnable{
    private int materialNum=100;
    private Taiwanese taiwanese;

    public Producer(Taiwanese taiwanese) {
        this.taiwanese = taiwanese;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (taiwanese.mask.getNum()>20){
                        print("More than 20 masks already in production");
                        wait();
                        print("After produce run wait");
                    }
                }
                if (materialNum<1){
                    print("Out of material.closing");
                    taiwanese.executorService.shutdownNow();
                }
                print("Start produce mask."+taiwanese.mask.getNum()+" masks left!");
                synchronized (taiwanese.consumer){
                    taiwanese.mask.increment(10);
                    materialNum=materialNum-10;
                    taiwanese.consumer.notifyAll();
                }
                TimeUnit.MICROSECONDS.sleep(1);
            }
        }catch (InterruptedException e){
            print("Producer interrupted");
        }
    }
}
class Consumer implements Runnable{
    private Taiwanese taiwanese;

    public Consumer(Taiwanese taiwanese) {
        this.taiwanese = taiwanese;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (taiwanese.mask.getNum()<1){
                        print("Out of storage masks.Please wait!");
                        wait();
                    }
                }
                print("Start consumer");
                synchronized (taiwanese.producer){
                    taiwanese.mask.decrement();
                    print("Consumer got a mask."+taiwanese.mask.getNum()+" masks left!");
                    if (taiwanese.mask.getNum()<10){
                        print("Notify producer");
                        taiwanese.producer.notifyAll();
                    }
                }
            }
        }catch (InterruptedException e){
            print("Consumer interrupted");
        }
    }
}

public class Taiwanese {
    Mask mask=new Mask(10);
    ExecutorService executorService= Executors.newCachedThreadPool();
    Producer producer=new Producer(this);
    Consumer consumer=new Consumer(this);

    public Taiwanese() {
        executorService.execute(producer);
        executorService.execute(consumer);
//        while (mask.getNum()>1000){
//            print("Out of material.closing");
//            f.cancel(true);
//        }
    }

    public static void main(String[] args) {
        new Taiwanese();
    }
}