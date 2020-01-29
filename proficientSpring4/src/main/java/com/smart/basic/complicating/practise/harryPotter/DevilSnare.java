package com.smart.basic.complicating.practise.harryPotter;

import java.util.concurrent.atomic.AtomicInteger;

public class DevilSnare {
    private AtomicInteger energy;

    public void setEnergy(AtomicInteger energy) {
        this.energy = energy;
    }

    public AtomicInteger getEnergy() {
        return energy;
    }
    public DevilSnare(AtomicInteger energy) {
        this.energy = energy;
    }
    public SuccessOfFailure check(){
        if (energy.get()<3){
            return SuccessOfFailure.FAILURE;
        }else {
            return SuccessOfFailure.SUCCESS;
        }
    }
}
