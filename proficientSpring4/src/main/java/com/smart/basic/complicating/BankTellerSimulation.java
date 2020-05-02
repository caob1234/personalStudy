package com.smart.basic.complicating;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

//Read-only objects don't require synchronization
class Customer{
    private final int serviceTime;
    public Customer(int tm){serviceTime=tm;}

    public int getServiceTime() {
        return serviceTime;
    }

}
//Teach the customer line to display itself
class CustomerLine extends ArrayBlockingQueue<Customer> {
    public CustomerLine(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        if (this.size()==0)
            return "[Empty]";
        StringBuilder result=new StringBuilder();
        for (Customer customer:this){
            result.append(customer);
        }
        return result.toString();
    }
}
class CustomerGenerator implements Runnable{
    private CustomerLine customers;
    private static Random rand=new Random(47);

    public CustomerGenerator(CustomerLine customers) {
        this.customers = customers;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        }catch (InterruptedException e){
            System.out.println("CustomerGenerator interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}
class Teller implements Runnable,Comparable<Teller>{
    private static int counter=0;
    private final int id=counter++;
    //Customers served during this shift
    private int customersServed=0;
    private CustomerLine customers;
    private boolean servingCustomerLine=true;

    public Teller(CustomerLine cq) {
        this.customers = cq;
    }

    //Used by priority queue:
    @Override
    public int compareTo(Teller other) {
        return customersServed<other.customersServed?-1:(
                customersServed==other.customersServed?0:1);
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                Customer customer=customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this){
                    customersServed++;
                    while (!servingCustomerLine){
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println(this+" interrupted");
        }
        System.out.println(this+" terminating");
    }
    public synchronized void doSomeThingElse(){
        customersServed=0;
        servingCustomerLine=false;
    }
    public synchronized void serveCustomerLine(){
        assert !servingCustomerLine:"already serving:"+this;
        servingCustomerLine=true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller" + "id=" + id + " ";
    }
    public String shortString(){
        return "T"+id;
    }
}
class TellerManager implements Runnable{
    private ExecutorService exec;
    private CustomerLine customers;
//    private PriorityQueue<>
    @Override
    public void run() {

    }
}
public class BankTellerSimulation {
}
