package com.smart.basic.complicating.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

class Car {
    private boolean waxOn = false;
    private int i=9;
    private boolean waxOnBe(){
        return i%5==0;

    }
    public synchronized void waxed() {
        waxOn = true; // Ready to buff
        notifyAll();
    }
    public synchronized void buffed(){
        waxOn=false;//Ready for another coat of wax
        notifyAll();
    }
    public synchronized void waitForWaxing()throws InterruptedException{
        waxOnBe();
        while (waxOn==false){
            print("I'm waxing");
            wait();
        }
    }
    public synchronized void waitForBuffing()throws InterruptedException{
        waxOnBe();
        while (waxOn==true){
            wait();
        }
    }
}
class WaxOn implements Runnable{
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                printnb("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e){
            print("Exiting via interrupt.");
        }
        print("Ending Wax on task.");
    }
}
class WaxOff implements Runnable{
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                car.waitForWaxing();
                printnb("Wax off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e){
            print("Exiting via interrupt.");
        }
        print("Ending Wax off task.");
    }
}
public class WaxOMatic {
    public static void main(String[] args)throws Exception{
        Car car=new Car();
        ExecutorService exec= Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
