package com.smart.basic.complicating.practise.harryPotter;

import com.smart.basic.complicating.practise.harryPotter.Character;

import java.util.concurrent.atomic.AtomicInteger;

public class Harry extends Character implements Runnable{
    private DevilSnare devilSnare;
    public Harry(DevilSnare devilSnare) {
        super(devilSnare.getEnergy());
        this.devilSnare=devilSnare;
    }

    @Override
    public String beatVoldemort() {
        return null;
    }
    @Override
    public void run() {
        String s="Harry already start:"+energy;
        System.out.println("");
        add("",10);
        devilSnare.setEnergy(energy);
    }
}
