package com.smart.basic.complicating.producerConsumers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class PublicResource {
    private volatile int number = 0;
    private final int size = 10;

    public synchronized void increase() throws InterruptedException {
        while (number >= size) {
//            try {
            wait();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
        }
        number++;
        System.out.println("Produced a publicResource,total " + number);
        notifyAll();
    }

    public synchronized void decrease() throws InterruptedException {
        while (number <= 0) {
//            try {
            wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        number--;
        System.out.println("Consumed a publicResource,total " + number);
        notifyAll();
    }
}

class ProducerThread implements Runnable {
    private PublicResource resource;


    public ProducerThread(PublicResource resource) {
        this.resource = resource;
    }


    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
                resource.increase();
            }
        } catch (InterruptedException e) {
            System.out.println("Producer has been interrupted----------");
        }

    }
}

class ConsumerThread implements Runnable {

    private PublicResource resource;


    public ConsumerThread(PublicResource resource) {
        this.resource = resource;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
                resource.decrease();
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer has been interrupted~~~~~~~~");
        }

    }


}

public class ProducerConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        PublicResource resource = new PublicResource();
        ExecutorService exec = Executors.newCachedThreadPool();
//        new Thread(new ProducerThread(resource)).start();
//        new Thread(new ConsumerThread(resource)).start();
//        new Thread(new ProducerThread(resource)).start();
//        new Thread(new ConsumerThread(resource)).start();
//        new Thread(new ProducerThread(resource)).start();
//        new Thread(new ConsumerThread(resource)).start();
        exec.execute(new ProducerThread(resource));
        exec.execute(new ConsumerThread(resource));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}
