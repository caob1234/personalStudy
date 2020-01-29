package com.smart.basic.complicating.practise.harryPotter;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Character {
    protected AtomicInteger energy;
    public Character(AtomicInteger energy) {
        this.energy = energy;
    }
    public abstract String beatVoldemort();
    public AtomicInteger add(){
        energy.incrementAndGet();
        return energy;
    };
    public void reduce(){
        energy.decrementAndGet();
    }

}
