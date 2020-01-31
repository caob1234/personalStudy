package com.smart.basic.complicating.practise.harryPotter;

import com.smart.basic.complicating.SyncObject;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Character {
    protected Integer energy;
    public Character(int energy) {
        this.energy = energy;
    }
    public abstract String beatVoldemort();
    public int add(String s,int i){
        synchronized (energy){
            System.out.println(s+" add---------------");
            for (int j=0;j<i;j++){
                energy++;
            }
        }
        return energy;
    };
    public void reduce(){
        energy--;
    }

}
