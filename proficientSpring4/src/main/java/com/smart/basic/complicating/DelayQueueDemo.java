package com.smart.basic.complicating;

import net.mindview.util.CountingGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

class DelayedTask implements Runnable, Delayed{
    private static int counter=0;
    private final int id=counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence=new ArrayList<>();

    public DelayedTask(int delayInMilliseconds) {
        this.delta = delayInMilliseconds;
        trigger=System.nanoTime()+NANOSECONDS.convert(delta,MILLISECONDS);
        sequence.add(this);
    }
    @Override
    public long getDelay(TimeUnit unit){
        return unit.convert(trigger-System.nanoTime(),NANOSECONDS);
    }
    @Override
    public int compareTo(Delayed o) {
        DelayedTask that= (DelayedTask) o;
        if (trigger<that.trigger) return -1;
        if (trigger>that.trigger) return 1;
        return 0;
    }

    @Override
    public void run() {
        printnb(this+" ");
    }

    @Override
    public String toString() {
        return "DelayedTask{" + "id=" + id + ", delta=" + delta + ", trigger=" + trigger + '}';
    }
    public String summary(){
        return "("+id+":"+delta+")";
    }
    public static class EndSentinel extends DelayedTask{
        private ExecutorService exec;

        public EndSentinel(int delayInMilliseconds, ExecutorService exec) {
            super(delayInMilliseconds);
            this.exec = exec;
        }
        public void run(){
            for (DelayedTask pt:sequence){
                printnb(pt.summary()+" ");
            }
            print();
            print(this+" Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
class DelayedTaskConsumer implements Runnable{
    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                q.take().run();
            }
        }catch(InterruptedException e){
            //Acceptable way to exit
        }
        print("Finished DelayedTaskConsumer");
    }
}
public class DelayQueueDemo {
    public static void main(String[] args){
        Random random=new Random(47);
        ExecutorService exec= Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue=new DelayQueue<>();
        //Fill with tasks that have random delays
        for (int i=0;i<20;i++)
            queue.put(new DelayedTask(random.nextInt(5000)));
        //Set the stopping point
        queue.add(new DelayedTask.EndSentinel(5000,exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}
