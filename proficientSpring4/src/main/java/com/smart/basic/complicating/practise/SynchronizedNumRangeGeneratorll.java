package com.smart.basic.complicating.practise;

import com.smart.basic.complicating.practise.NumRangeCheckerll;
import com.smart.basic.complicating.practise.NumRangeGenerator;
import com.smart.basic.complicating.practise.NumRangeGeneratorll;

import java.util.Random;

public class SynchronizedNumRangeGeneratorll extends NumRangeGenerator {
    private int min = 0;
    private int max = 0;
    private int[] range = {min,max};
    private Random random = new Random();
    @Override
    public synchronized int[] next() {
        min = random.nextInt(100);
        max = random.nextInt(100);
        Thread.yield();
        if (min>max) max=min;
        int[] ia = {min,max};
        return ia;
    }
    public static void main(String[] args){
        NumRangeCheckerll.test(new NumRangeGeneratorll());
    }
}
