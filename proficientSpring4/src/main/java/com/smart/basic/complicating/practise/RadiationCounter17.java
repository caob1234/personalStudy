package com.smart.basic.complicating.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class RadCount{
    private int count=0;
    private Random random=new Random();
    public synchronized int increment(){
        return count++;
    }
    public synchronized int value(){
        return count;
    }
}
class Sensors implements Runnable{
    private static RadCount count=new RadCount();
    private static List<Sensors> sensors=
            new ArrayList<>();
    private int numbers=0;

    public Sensors(int id) {
        this.id = id;
        sensors.add(this);
    }

    //Does't need synchronized to read
    private final int id;
    private static volatile boolean canceled=false;
    //Atomic operation on a volatile field
    public static void cancel(){canceled=true;}
    @Override
    public void run() {
        while (!canceled){
            synchronized (this){
                ++numbers;
            }
            print(this+" Total:"+count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            }catch (InterruptedException e){
                print("sleep interrupted");
            }
        }
        print("Stopping "+this);
    }
    public synchronized int getValue(){return numbers;}

    @Override
    public String toString() {
        return "Sensors "+id+":" + getValue();
    }
    public static int getTotalCount(){
        return count.value();
    }
    public static int sunSensors(){
        int sum=0;
        for (Sensors sensor:sensors){
            sum+=sensor.getValue();
        }
        return sum;
    }
}
public class RadiationCounter17 {
    public static void main(String[] args)throws Exception{
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            executorService.execute(new Sensors(i));
        }
        TimeUnit.MILLISECONDS.sleep(4);
        Sensors.cancel();
        executorService.shutdown();
        if (!executorService.awaitTermination(250,TimeUnit.MILLISECONDS))
            print("Some tasks were not terminated");
        print("Total:"+Sensors.getTotalCount());
        print("Sum of Sensors:"+Sensors.sunSensors());
    }
}

