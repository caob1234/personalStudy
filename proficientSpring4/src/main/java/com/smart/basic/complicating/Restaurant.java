package com.smart.basic.complicating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" + "orderNum=" + orderNum + '}';
    }
}

class TableWare {
    private Meal meal;

    public TableWare(Meal meal) {
        this.meal = meal;
    }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;
    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try{

                while (restaurant.meal == null||restaurant.tableWare==null) {
                    print("waitPerson wait");
                    condition.await();
                }
                }finally {
                    lock.unlock();
                }

                printnb("Waitperson got " + restaurant.meal + ".");
                TimeUnit.MILLISECONDS.sleep(100);
                restaurant.busboy.lock.lock();
                try {

                restaurant.meal = null;
                printnb("WaitPerson finished!");
                TimeUnit.MILLISECONDS.sleep(200);
                restaurant.busboy.condition.signalAll();
                }finally {
                    restaurant.busboy.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            print("WitPerson interrupted");
        }
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;
    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            print(restaurant.s);
            while (!Thread.interrupted()) {
                lock.lock();
                try {

                while (restaurant.meal != null || restaurant.tableWare != null) {
                    condition.await();
                }
                }finally {
                    lock.unlock();
                }

                if (++count == 10) {
                    print("Out of food.closing");
                    restaurant.executorService.shutdownNow();
                    TimeUnit.MILLISECONDS.sleep(100);
                }
                print("Order up! ");
                restaurant.waitPerson.lock.lock();
                try {

                restaurant.meal = new Meal(count);
                restaurant.tableWare = new TableWare(restaurant.meal);
                printnb("Chef finished!");
                restaurant.waitPerson.condition.signalAll();
                TimeUnit.MILLISECONDS.sleep(100);

                }finally {
                    restaurant.waitPerson.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}

class Busboy implements Runnable {
    private Restaurant restaurant;
    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();
    public Busboy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try{

                while (restaurant.tableWare == null||restaurant.meal!=null) {
                    condition.await();
                }
                }finally {
                    lock.unlock();
                }
                restaurant.chef.lock.lock();
                try {

                restaurant.tableWare = null;
                printnb("Busboy finished!\n");
                TimeUnit.MILLISECONDS.sleep(200);
                restaurant.chef.condition.signalAll();
                }finally {
                    restaurant.chef.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            print("BusBoy interrupted");
        }
    }
}

public class Restaurant {
    Meal meal;
    TableWare tableWare;
    ExecutorService executorService = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    Busboy busboy = new Busboy(this);

    public Restaurant() {
        executorService.execute(chef);
        executorService.execute(waitPerson);
        executorService.execute(busboy);
    }

    StringBuffer s = new StringBuffer("A object");

    public static void main(String[] args) {
        new Restaurant();
    }
}
