package com.smart.basic.complicating.practise;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class NumRangeGenerator{
    private volatile boolean canceled=false;
    public abstract int[] next();
    public void cancel(){
        canceled=true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
class NumRangeCheckerll implements Runnable{
    private NumRangeGenerator generator;
    private final int id;

    public NumRangeCheckerll(NumRangeGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Testing..");
        while (!generator.isCanceled()){
            int[] range=generator.next();
            if (range[0]>range[1]){
                System.out.println("Error in test #"+id+":min"+range[0]+
                        ">max "+range[1]);
                generator.cancel();
            }
        }
    }
    public static void test(NumRangeGenerator generator,int count){
        System.out.println("Press Ctrl-C to exit");
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<count;i++){
            executorService.execute(new NumRangeCheckerll(generator,i));
        }
        executorService.shutdown();
    }
    public static void test(NumRangeGenerator generator){
        test(generator,10);
    }
}
public class NumRangeGeneratorll extends NumRangeGenerator {
    private int min = 0;
    private int max = 0;
    private int[] range = {min,max};
    private Random random = new Random();
    @Override
    public int[] next() {
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
