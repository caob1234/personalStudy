package com.smart.basic.complicating;

public class Chopstick {
    public boolean isTaken() {
        return taken;
    }

    private boolean taken=false;

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
    public synchronized void take()throws InterruptedException{
        while (taken){
            wait();
        }
        taken=true;
    }
    public synchronized void drop(){
        taken=false;
        notifyAll();
    }
}
