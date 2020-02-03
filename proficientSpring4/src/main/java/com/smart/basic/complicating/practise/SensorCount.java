package com.smart.basic.complicating.practise;

import sun.lwawt.macosx.CPrinterDevice;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class Count{
    public int getCount() {
        return count;
    }

    private int count=0;
    public synchronized int increment(){
        return ++count;
    }
}
class Sensor implements Runnable{
    private static Count count=new Count();
    private int num=0;
    public Sensor(int sensorId) {
        this.sensorId = sensorId;
    }
    private int sensorId;
    private static volatile boolean canceled=false;
    public static void cancel(){
        canceled=true;
    }

    @Override
    public void run() {
        while (!canceled){
            synchronized (this){
                num++;
            }
            print(this+" total="+count.increment());
        }
    }
    public synchronized int getValue() {return num;}

    @Override
    public String toString() {
        return "Sensor{" + "num=" + getValue() + ", sensorId=" + sensorId + '}';
    }
}
public class SensorCount {
    public static void main(String[] args) throws IOException {
        int j=5;
//        System.out.println(j);
//        System.in.read();
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<j;i++){
            executorService.execute(new Sensor(i));
        }
        try {
            TimeUnit.MICROSECONDS.sleep(3);
        } catch (InterruptedException e) {
            ;
        }
        Sensor.cancel();
        executorService.shutdown();
    }
}
