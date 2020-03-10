package com.smart.basic.complicating;

import com.smart.basic.complicating.practise.Bin;
import com.smart.basic.complicating.practise.PhilosopherByQueue;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

public class DeadlockingDiningPhilosophers {
    public static void main(String[] args)throws Exception{
        String[] strs=new String[3];
//        for (int i=0;i<3;i++){
//            strs[i]=i+"";
//        }
        strs= new String[]{"1", "2", "3"};
        Bin bin=new Bin();
        int ponder =5;
        if (args.length>0){
            ponder=Integer.parseInt(args[0]);
        }
        int size=5;
        if (args.length>1){
            size=Integer.parseInt(args[1]);
        }
        ExecutorService executorService= Executors.newCachedThreadPool();
        Chopstick[] sticks=new Chopstick[size];
        for (int i=0;i<size;i++){
            sticks[i]=new Chopstick();
        }
        for (int i=0;i<size;i++){
            executorService.execute(new PhilosopherByQueue(sticks[i],sticks[(i+1)%size], i,ponder,bin));
        }
        if (args.length==3&&args[2].equals("timeout")){
            TimeUnit.SECONDS.sleep(5);
        }else {
            print("Press 'Enter' to quit");
            System.in.read();
        }
        executorService.shutdownNow();
    }
}
