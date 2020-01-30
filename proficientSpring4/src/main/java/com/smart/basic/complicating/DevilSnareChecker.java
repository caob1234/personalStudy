package com.smart.basic.complicating;

import com.smart.basic.complicating.practise.harryPotter.DevilSnare;
import com.smart.basic.complicating.practise.harryPotter.SuccessOfFailure;

import java.util.concurrent.Callable;

public class DevilSnareChecker implements Callable<SuccessOfFailure> {
    private DevilSnare devilSnare;
    public DevilSnareChecker(DevilSnare devilSnare) {
        this.devilSnare = devilSnare;
    }

    @Override
    public SuccessOfFailure call() throws Exception {
        return devilSnare.check();
    }
}
