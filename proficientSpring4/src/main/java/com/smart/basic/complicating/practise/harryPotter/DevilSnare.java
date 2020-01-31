package com.smart.basic.complicating.practise.harryPotter;

import java.util.concurrent.atomic.AtomicInteger;

public class DevilSnare {
    private Integer energy;

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getEnergy() {
        return energy;
    }
    public DevilSnare(Integer energy) {
        this.energy = energy;
    }
    public SuccessOfFailure check(){
//        System.out.println("check method print:"+energy);
        if (energy.intValue()==30){
            return SuccessOfFailure.SUCCESS;
        }else {
            return SuccessOfFailure.FAILURE;
        }
    }
}
