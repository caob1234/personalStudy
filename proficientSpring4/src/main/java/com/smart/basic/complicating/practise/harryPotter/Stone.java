package com.smart.basic.complicating.practise.harryPotter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Stone {
    private AtomicInteger energy=new AtomicInteger(0);
    public SuccessOfFailure breakDevilSnare(){
        DevilSnare devilSnare=new DevilSnare(energy);
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new Hermione(devilSnare));
        executorService.execute(new Harry(devilSnare));
        executorService.execute(new Ron(devilSnare));
        while (devilSnare.check().equals(SuccessOfFailure.FAILURE)){
            devilSnare.check();
        }
        return devilSnare.check();
    }
    public void flyingKey(){

    }
    public void wizardChess(){

    }
    public void mirrorErised(){

    }
    public void check(){
    }
}
