package com.smart.basic.complicating.practise.harryPotter;

import java.util.concurrent.atomic.AtomicInteger;

public class DevilSnare {
    private int energy;

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }
    public DevilSnare(int energy) {
        this.energy = energy;
    }
    public SuccessOfFailure check(){
        System.out.println("check method print:"+energy);
        if (energy==3){
            return SuccessOfFailure.SUCCESS;
        }else {
            return SuccessOfFailure.FAILURE;
        }
    }
}
