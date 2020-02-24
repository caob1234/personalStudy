package com.smart.basic.complicating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class Meal{
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" + "orderNum=" + orderNum + '}';
    }
}
class WaitPerson implements Runnable{
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                        print("After waitPerson wait");
                    }
                }
                print("Waitperson got "+restaurant.meal);
                TimeUnit.MILLISECONDS.sleep(100);
                synchronized (restaurant.chef){
                    print("After restaurant.chef sync");
                    restaurant.meal=null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            print("WitPerson interrupted");
        }
    }
}
class Chef implements Runnable{
    private Restaurant restaurant;
    private int count=0;
    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal!=null){
                        print("Before chef wait");
                        wait();
                        print("After chef wait");
                    }
                }
                if (++count==10){
                    print("Out of food.closing");
                    restaurant.executorService.shutdownNow();
                }
                print("Order up! ");
                synchronized (restaurant.waitPerson){
                    restaurant.meal=new Meal(count);
                    restaurant.waitPerson.notifyAll();
                    print("After waitPerson notifyAll");
                }
                print("Ready sleep or wait");
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            print("Chef interrupted");
        }
    }
}
public class Restaurant {
    Meal meal;
    ExecutorService executorService= Executors.newCachedThreadPool();
    WaitPerson waitPerson=new WaitPerson(this);
    Chef chef=new Chef(this);

    public Restaurant() {
        executorService.execute(chef);
        executorService.execute(waitPerson);
    }
    public static void main(String[] args){
        new Restaurant();
    }
}
