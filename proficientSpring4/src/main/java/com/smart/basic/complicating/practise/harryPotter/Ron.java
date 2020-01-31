package com.smart.basic.complicating.practise.harryPotter;

import com.smart.basic.complicating.practise.harryPotter.Character;

import java.util.concurrent.atomic.AtomicInteger;

public class Ron extends Character implements Runnable{
    private DevilSnare devilSnare;
    public Ron(DevilSnare devilSnare) {
        super(devilSnare.getEnergy());
        this.devilSnare=devilSnare;
    }
    @Override
    public String beatVoldemort() {
        return null;
    }

    @Override
    public void run() {
        String s="Ron already start:"+energy;
        System.out.println("");
        add(s,5);
        devilSnare.setEnergy(energy);
    }
}
