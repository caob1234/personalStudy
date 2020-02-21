package com.smart.basic.complicating.practise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.eclipse.osgi.internal.debug.Debug.println;

class A implements Runnable{
    private volatile boolean signal=false;
    @Override
    public synchronized void run() {
        try {
            while (!signal){
                println("A.run() wait");
                wait();
                signal=true;
                println("A is done waiting");
            }
        }catch (InterruptedException e){
            println("A run() interrupted");
        }finally {
            println("Leaving A.run()");
        }
    }
    public synchronized void message(){
        println("Hi from A");
    }
}
class B implements Runnable{
    private A a;
    public B(A a) {
        this.a = a;
    }
    public A getA() {
        return a;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
            synchronized (a){
                println("B.run() a.notifyAll()");
                a.notifyAll();
            }
        }catch (InterruptedException e){
            System.out.println("B sleep inerrupted");
        }
    }
}
public class Ex21 {
    public static void main(String[] args){
        ExecutorService executorService= Executors.newCachedThreadPool();
        B b=new B(new A());
        executorService.execute(b.getA());
        try{
            TimeUnit.MILLISECONDS.sleep(100);
        }catch (InterruptedException e){
            System.out.println("main() sleep interrupted");
        }
        b.getA().message();
        executorService.execute(b);
        try {
            TimeUnit.MILLISECONDS.sleep(2500);
        }catch (InterruptedException e){
            System.out.println("main() sleep interrupted");
        }
        executorService.shutdownNow();
    }
}
