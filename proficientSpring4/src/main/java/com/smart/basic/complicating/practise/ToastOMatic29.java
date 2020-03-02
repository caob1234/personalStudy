package com.smart.basic.complicating.practise;

import java.util.Random;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

class Toast{
    public enum Status{DRY,BUTTERED,JAMMED}
    private Status status= Status.DRY;
    private final int id;
    public Toast(int id) {
        this.id = id;
    }
    public void butter(){
        status= Status.BUTTERED;
    }
    public void jam(){
        status= Status.JAMMED;
    }
    public Status getStatus(){
        return status;
    }
    public int getId(){
        return id;
    }
    @Override
    public String toString(){
        return "Toast "+id+":"+status;
    }
}
class ToastQueue extends LinkedBlockingQueue<Toast>{}
class Toaster implements Runnable{
    private ToastQueue toastQueue;
    private int count=0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100+rand.nextInt(500));
                //Make toast
                Toast t=new Toast(count++);
                print(t);
                //Insert into queue
                toastQueue.put(t);
            }
        }catch (InterruptedException e){
            print("Toaster interrupted");
        }
        print("Toaster off");
    }
}
//Apply butter to toast
class Butterer implements Runnable{
    private ToastQueue dryQueue,butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                //Blocks until next piece of toast is available
                Toast t=dryQueue.take();
                t.butter();
                print(t);
                butteredQueue.put(t);
            }
        }catch (InterruptedException e){
            print("Butterer off");
        }
    }
}
//Apply jam to buttered toast
class Jammer implements Runnable{
    private ToastQueue dryQueue,jamQueue;

    public Jammer(ToastQueue dryQueue, ToastQueue jamQueue) {
        this.dryQueue = dryQueue;
        this.jamQueue = jamQueue;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                //Blocks until next piece of toast is available
                Toast t=dryQueue.take();
                t.jam();
                print(t);
                jamQueue.put(t);
            }
        }catch (InterruptedException e){
            print("Jammer interrupted");
        }
        print("Jammer off");
    }
}
class Sandwich{
    private Toast top,bottom;
    private int id;

    public Sandwich(Toast top, Toast bottom, int id) {
        this.top = top;
        this.bottom = bottom;
        this.id = id;
    }

    public Toast getTop() {
        return top;
    }

    public Toast getBottom() {
        return bottom;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sandwich{" + "top=" + top + ", bottom=" + bottom + ", id=" + id + '}';
    }
}
class SandwichQueue extends LinkedBlockingQueue<Sandwich>{}
class SandwichMaker implements Runnable{
    private int count=0;
    private ToastQueue butteredQueue,jamQueue;
    private SandwichQueue sandwiches;

    public SandwichMaker(ToastQueue butteredQueue, ToastQueue jamQueue, SandwichQueue sandwiches) {
        this.butteredQueue = butteredQueue;
        this.jamQueue = jamQueue;
        this.sandwiches = sandwiches;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Sandwich sandwich=new Sandwich(butteredQueue.take(),jamQueue.take(),count++);
                sandwiches.put(sandwich);
            }
        }catch (InterruptedException e){
            print("SandwichMaker interrupted!");
        }
        print("SandwichMaker off");
    }
}
//Consume the toast
class Eater implements Runnable{
    private SandwichQueue sandwiches;
    private int counter=0;

    public Eater(SandwichQueue sandwiches) {
        this.sandwiches = sandwiches;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                //Blocks until next piece of toast is available
                Sandwich sandwich=sandwiches.take();
                //Verify that the toast is coming in order and that
                // all pieces are getting jammed
                if (sandwich.getId()!=counter++||
                        sandwich.getTop().getStatus()!= Toast.Status.BUTTERED
                        ||sandwich.getBottom().getStatus()!=Toast.Status.JAMMED){
                    print(">>>>Error:"+sandwich);
                    System.exit(1);
                }else
                    print("Chomp! "+sandwich);
            }
        }catch (InterruptedException e){
            print("Eater interrupted");
        }
        print("Eater off");
    }
}
public class ToastOMatic29 {
    public static void main(String[] args)throws Exception{
        SandwichQueue sandwiches=new SandwichQueue();
        ToastQueue dryQueue=new ToastQueue(),
                butteredQueue=new ToastQueue(),
                jamQueue=new ToastQueue();
        ExecutorService exec= Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue,butteredQueue));
        exec.execute(new Jammer(dryQueue,jamQueue));
        exec.execute(new SandwichMaker(butteredQueue,jamQueue,sandwiches));
        exec.execute(new Eater(sandwiches));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
