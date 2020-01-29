package com.smart.basic.complicating.practise.harryPotter;

import com.smart.basic.complicating.practise.harryPotter.Character;

import java.util.concurrent.atomic.AtomicInteger;

public class Hermione extends Character implements Runnable {
    private DevilSnare devilSnare;
    public Hermione(DevilSnare devilSnare) {
        super(devilSnare.getEnergy());
        this.devilSnare=devilSnare;
    }

    @Override
    public String beatVoldemort() {
        return null;
    }

    @Override
    public void run() {
        devilSnare.setEnergy(add());
    }
}
