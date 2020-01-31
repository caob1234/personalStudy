package com.smart.basic.complicating.practise.harryPotter;

import com.smart.basic.complicating.DevilSnareChecker;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Stone {
    private Integer energy=new Integer(0);
    public SuccessOfFailure breakDevilSnare() throws ExecutionException, InterruptedException {
        DevilSnare devilSnare=new DevilSnare(energy);
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new Hermione(devilSnare));
        executorService.execute(new Harry(devilSnare));
        executorService.execute(new Ron(devilSnare));
//        Future<SuccessOfFailure> future=
//                executorService.submit(new DevilSnareChecker(devilSnare));
        while (devilSnare.check().equals(SuccessOfFailure.FAILURE)){
            devilSnare.check();
        }
//        TimeUnit.MILLISECONDS.sleep(50);
//        return future.get();
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
