package com.smart.basic.complicating.practise;

import java.util.concurrent.*;

import static net.mindview.util.Print.print;

class D{
    private volatile int knowLedgeNum=0;

    public int getKnowLedgeNum() {
        return knowLedgeNum;
    }
    public synchronized void learn(){
        print("I'm learning");
        knowLedgeNum=knowLedgeNum+5;
        notifyAll();
    }
    public synchronized void exercise(){
        print("I'm exercising");
        knowLedgeNum++;
        notifyAll();
    }
    public synchronized void add(String s){
        knowLedgeNum++;
        print(s+" "+knowLedgeNum);
    }
    public synchronized void waitForExercise() throws InterruptedException {
        while (knowLedgeNum%5==0){
            wait();
        }
    }
    public synchronized void waitForLearn(String name) throws InterruptedException{
        print("waitForLearn "+knowLedgeNum);
        while (knowLedgeNum==0||knowLedgeNum%5!=0){
            print("I'm learning.Please wait!"+" "+name);
            wait();
        }
    }
}
class Learn implements Runnable{
    private D d;
    public Learn(D d) {
        this.d = d;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(200);
                d.learn();
                d.waitForExercise();
//                while (d.getKnowLedgeNum()%2==0){
//                    print("I'm exercising.Please wait!");
//                }
            }
        } catch (InterruptedException e) {
            print("Learn interrupted");
        }
        print("Exiting learn via interrupted");
    }
}
class Exercise implements Runnable{
    private D d;
    public Exercise(D d) {
        this.d = d;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                d.waitForLearn(Thread.currentThread().getName());
//                while (d.getKnowLedgeNum()%2!=0){
//                    print("I'm learning.Please wait!");
//                }
//                TimeUnit.MILLISECONDS.sleep(2);
//                d.add("I'm exercising "+Thread.currentThread().getName());
                d.exercise();
            }
        } catch (InterruptedException e) {
            print("Exercise interrupted");
        }
        print("Exiting exercise via interrupted");
    }
}
public class Ex22 {

    public static void main(String[] args) throws InterruptedException {
        D d=new D();
        //    ExecutorService executorService= Executors.newCachedThreadPool();
        ExecutorService executorService=new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        executorService.execute(new Learn(d));
        executorService.execute(new Exercise(d));
        TimeUnit.SECONDS.sleep(10);
        executorService.shutdownNow();
    }
}
