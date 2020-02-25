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
class TableWare{
    private Meal meal;

    public TableWare(Meal meal) {
        this.meal = meal;
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
                    }
                }
                print("Waitperson got "+restaurant.meal);
                TimeUnit.MILLISECONDS.sleep(100);
                synchronized (restaurant.busboy){
                    restaurant.meal=null;
                    print("Customers have finished the eating.Notify busboy!");
                    restaurant.busboy.notifyAll();
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
                    while (restaurant.meal!=null||restaurant.tableWare!=null){
                        wait();
                    }
                }
                if (++count==10){
                    print("Out of food.closing");
                    restaurant.executorService.shutdownNow();
                    TimeUnit.MILLISECONDS.sleep(100);
//                    return;
                }
                print("Order up! ");
                synchronized (restaurant.waitPerson){
                    restaurant.meal=new Meal(count);
                    restaurant.tableWare=new TableWare(restaurant.meal);
                    print("The Chef finished a dish.Notify waitPerson!");
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            print("Chef interrupted");
        }
    }
}
class Busboy implements Runnable{
    private Restaurant restaurant;

    public Busboy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.tableWare==null){
                        wait();
                    }
                }

                synchronized (restaurant.chef){
                    restaurant.tableWare=null;
                    print("Busboy washed the dishes.Notify chef!");
                    restaurant.chef.notifyAll();
                }
            }
        }catch (InterruptedException e){
            print("BusBoy interrupted");
        }
    }
}
public class Restaurant {
    Meal meal;
    TableWare tableWare;
    ExecutorService executorService= Executors.newCachedThreadPool();
    WaitPerson waitPerson=new WaitPerson(this);
    Chef chef=new Chef(this);
    Busboy busboy=new Busboy(this);
    public Restaurant() {
        executorService.execute(chef);
        executorService.execute(waitPerson);
        executorService.execute(busboy);
    }
    public static void main(String[] args){
        new Restaurant();
    }
}
