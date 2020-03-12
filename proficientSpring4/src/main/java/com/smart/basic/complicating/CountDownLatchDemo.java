package com.smart.basic.complicating;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

//class Driver { // ...
//    void main() throws InterruptedException {
//      CountDownLatch startSignal = new CountDownLatch(1);
//      CountDownLatch doneSignal = new CountDownLatch(N);
//
//      for (int i = 0; i < N; ++i) // create and start threads
//        new Thread(new Worker(startSignal, doneSignal)).start();
//
//      doSomethingElse();            // don't let run yet
//      startSignal.countDown();      // let all threads proceed
//      doSomethingElse();
//      doneSignal.await();           // wait for all to finish
//    }
//  }
//
//class Worker implements Runnable {
//    private final CountDownLatch startSignal;
//    private final CountDownLatch doneSignal;
//    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
//      this.startSignal = startSignal;
//      this.doneSignal = doneSignal;
//    }
//    public void run() {
//      try {
//        startSignal.await();
//        doWork();
//        doneSignal.countDown();
//      } catch (InterruptedException ex) {} // return;
//    }
//
//            void doWork() {  }
//  }
//Performs some portion of a task
class TaskPortion implements Runnable{
    private static int counter=0;
    private final int id=counter++;
    private static Random random=new Random(47);
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        }catch (InterruptedException e){
            //Acceptable way to exit
        }
    }

    private void doWork() throws InterruptedException{
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        print(this+"completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d",id);
    }
}
//Waits on the CountDownLatch
class WaitingTask implements Runnable{
    private static int counter=0;
    private final int id=counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            print("Latch barrier passed for "+this);
        }catch (InterruptedException e){
            print(this+" interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d ",id);
    }
}
public class CountDownLatchDemo {
    static final int SIZE=10;
    public static void main(String[] args)throws Exception{
        ExecutorService service= Executors.newCachedThreadPool();
        //All must share a single CountDownLatch object
        CountDownLatch latch=new CountDownLatch(SIZE);
//        for (int i=0;i<10;i++)
            service.execute(new WaitingTask(latch));
        for (int i=0;i<SIZE;i++)
            service.execute(new TaskPortion(latch));
        print("Launched all tasks");
        service.shutdown();
    }
}
