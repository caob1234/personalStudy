package com.smart.basic.complicating;

//import concurrency.DaemonSpawn;
import java.util.concurrent.ThreadPoolExecutor;

class Daemon implements Runnable{
    private Thread[] t=new Thread[10];
    @Override
    public void run() {
        for (int i=0;i<t.length;i++){
//            t[i] = new Thread(new DaemonSpawn());
        }
    }
}
