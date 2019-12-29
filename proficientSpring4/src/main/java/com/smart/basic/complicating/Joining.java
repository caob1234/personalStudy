package com.smart.basic.complicating;

import static net.mindview.util.Print.print;

class Sleeper extends Thread{
    private int duration=0;

    public Sleeper(String name,int sleepTime) {
        super(name);
        duration=sleepTime;
        start();
    }

    public Sleeper(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        try{
            if (duration!=0){
                sleep(duration);
            }else {
                print(getName()+" is running");
            }
        }catch (InterruptedException e){
            print(getName()+" was interrupted "+
                    "isInterrupted "+isInterrupted());
            return;
        }
        print(getName()+" has awakened");
    }
}
class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }

    @Override
    public void run() {
        try{
            sleeper.join();
        }catch (InterruptedException e){
            print("interrupted");
        }
        print(getName()+" join completed");
    }
}
public class Joining {
    public static void main(String[] args){
        Sleeper sleepy=new Sleeper("Sleepy"),
                grumpy=new Sleeper("Grumpy",1500);
        Joiner dopey = new Joiner("Dopey",sleepy),
                doc=new Joiner("Doc",grumpy);
//        dopey.interrupt();
    }

}
