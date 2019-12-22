package com.smart.basic.complicating;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            print("Starting ADaemon");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        }finally {
            print("This should always run");
        }
    }
}
public class DaemonDontRunFinally{
    public static void main(String[] args)throws Exception{
        Thread t=new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}