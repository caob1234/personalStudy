package com.smart.basic.complicating.practise.harryPotter;

import com.smart.basic.complicating.SyncObject;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Character {
    protected int energy;
    public Character(int energy) {
        this.energy = energy;
    }
    public abstract String beatVoldemort();
    public synchronized int add(){
        energy++;
        return energy;
    };
    public void reduce(){
        energy--;
    }

}
