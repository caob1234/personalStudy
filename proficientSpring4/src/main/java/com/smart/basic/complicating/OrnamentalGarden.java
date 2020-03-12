package com.smart.basic.complicating;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class Count{
    private int count =0;
    private Random random=new Random(47);
    //Remove the synchronized keyword to see counting fail:
    public synchronized int increment(){
        int temp = count;
        if (random.nextBoolean()){
            Thread.yield();
        }
        return (count=++temp);
    }
    public synchronized int value(){
        return count;
    }
}
class Entrance implements Runnable{
    private static Count count=new Count();
    private static List<Entrance> entrances=
            new ArrayList<>();
    private int number=0;
    private CountDownLatch latch;
    //Doesn't need synchronization to read
    private final int id;
    private static volatile boolean canceled=false;
    //Atomic operation on a volatile field
    public static void cancel(){
        canceled=true;
    }
    Entrance(int id,CountDownLatch latch) {
        this.id = id;
        this.latch=latch;
        //Keep this task in a list.Also prevents garbage
        //collection of dead tasks;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled){
            synchronized (this){
                ++number;
            }
            print(this+" Total: "+count.increment());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                print("sleep interrupted");
            }
        }
        print("Stopping "+this);
        latch.countDown();

    }
    public synchronized int getValue() {return number;}

    @Override
    public String toString() {
        return "Entrance " + id+": " + getValue();
    }
    public static int getTotalCount(){
        return count.value();
    }
    public static int sumEntrances(){
        int sum=0;
        for (Entrance entrance:entrances)
            sum+=entrance.getValue();
        return sum;
    }
}
public class OrnamentalGarden {
    private static final int SIZE = 5;
    public static void main(String[] args)throws Exception{
        CountDownLatch latch=new CountDownLatch(SIZE);
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<SIZE;i++)
            executorService.execute(new Entrance(i,latch));
        //Run for a while,then stop and collect the data;
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        latch.await();
        executorService.shutdownNow();
        if (!executorService.awaitTermination(250,TimeUnit.MILLISECONDS))
            print("Some tasks were not terminated!");
        print("Total: "+Entrance.getTotalCount());
        print("Sum of Entrances:"+Entrance.sumEntrances());
    }
}
