package com.smart.basic.complicating.queue;

import java.util.Random;

class PrioritizedTask implements Runnable,Comparable<PrioritizedTask>{
    private Random rand = new Random(47);
    private static int counter=0;
    @Override
    public int compareTo(PrioritizedTask o) {
        return 0;
    }

    @Override
    public void run() {

    }
}
public class PriorityBlockingQueueDemo {
}
