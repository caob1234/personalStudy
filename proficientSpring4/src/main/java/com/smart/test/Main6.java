package com.smart.test;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Array {
    private volatile String[] strs;

    public synchronized String[] getStrs() {
        return strs;
    }

    public Array(String[] strs) {
        this.strs = strs;
    }

    public synchronized int getI() {
        return i;
    }

    private volatile int i = 0;

    public synchronized void waitForAddA() throws InterruptedException {
        while (i != 0 && strs[i - 1] != "D") {
            wait();
        }
    }

    public synchronized void waitForAddB() throws InterruptedException {
        while (i == 0 || strs[i - 1] != "A") {
            wait();
        }
    }

    public synchronized void waitForAddC() throws InterruptedException {
        while (i == 0 || strs[i - 1] != "B") {
            wait();
        }
    }

    public synchronized void waitForAddD() throws InterruptedException {
        while (strs[i - 1] != "C") {
            wait();
        }
    }

    public synchronized void add(String s) {
        strs[i] = s;
        i++;
        notifyAll();
    }
}

class A implements Runnable {
    private Array array;
    private int i;

    public A(Array array, int i) {
        this.array = array;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted() && i != 0) {
                array.waitForAddA();
                array.add("A");
                i--;
            }
        } catch (InterruptedException e) {
//            System.out.println("A was interrupted");
        }
    }
}

class B implements Runnable {
    private Array array;

    public B(Array array) {
        this.array = array;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                array.waitForAddB();
                array.add("B");
            }
        } catch (InterruptedException e) {
//            System.out.println("B was interrupted");
        }
    }
}

class C implements Runnable {
    private Array array;

    public C(Array array) {
        this.array = array;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                array.waitForAddC();
                array.add("C");
            }
        } catch (InterruptedException e) {
//            System.out.println("C was interrupted");
        }
    }
}

class D implements Runnable {
    private Array array;

    public D(Array array) {
        this.array = array;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                array.waitForAddD();
                array.add("D");
            }
        } catch (InterruptedException e) {
//            System.out.println("D was interrupted");
        }
    }
}

/**
 * https://www.nowcoder.com/practice/cd99fbc6154d4074b4da0e74224a1582?tpId=37&tqId=21272&tPage=3&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class Main6 {
    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            count = Integer.parseInt(input.nextLine());
            Array array = new Array(new String[count * 4]);
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new A(array, count));
            executorService.execute(new B(array));
            executorService.execute(new C(array));
            executorService.execute(new D(array));
            while (array.getI()<array.getStrs().length-1){
                TimeUnit.MILLISECONDS.sleep(1);
            }
            executorService.shutdownNow();
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i < array.getStrs().length; i++) {
                sb.append(array.getStrs()[i]);
            }
            System.out.println(sb.toString());
        }

    }
}
