package com.smart.basic.complicating;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.print;

class SleepBlocked implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            print("InterruptedException");
        }
        print("Exiting SleepBlocked.run()");
    }
}
class IOBlocked implements Runnable{
    private InputStream in;
    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        print("Waiting for read()");
        try {
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()){
                print("Interrupted from blocked I/O");
            }else {
                throw new RuntimeException(e);
            }
        }
        print("Exiting IOBlocked.run()");
    }
}
class SynchronizedBlocked implements Runnable{
    private ReentrantLock lock=new ReentrantLock();
    public void f(){
        try {
            lock.tryLock(3,TimeUnit.SECONDS);
            while (true){//Never releases lock
                Thread.yield();
            }
        } catch (InterruptedException e) {
            print("f() interrupted");
        }finally {
            print("exit the lock of f()");
            lock.unlock();
        }

    }
    public SynchronizedBlocked(){
        print("Constructor start");
        new Thread(){
            public void run(){
                f();//Lock acquired by this thread
            }
        }.start();
    }
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Trying to call f()");
        f();
        print("Exiting SynchronizedBlocked.run()");
    }
}
public class Interrupting {
    private static ExecutorService exec= Executors.newCachedThreadPool();
    static void test(Runnable r)throws InterruptedException{
        Future<?> f=exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
//        print("Interrupting "+r.getClass().getName());
        f.cancel(true);
        print("Interrupt sent to "+r.getClass().getName());
    }
    public static void main(String[] args)throws Exception{
//        test(new SleepBlocked());
//        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
//        TimeUnit.SECONDS.sleep(3);
//        print("Aborting with System.exit(0)");
//        System.exit(0);//...since last 2 interrupts failed
    }
}
