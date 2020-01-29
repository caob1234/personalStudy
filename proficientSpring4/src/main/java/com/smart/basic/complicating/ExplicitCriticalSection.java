package com.smart.basic.complicating;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExplicitPairManager1 extends PairManager{
    private Lock lock=new ReentrantLock();
    @Override
    public void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        }finally {
            lock.unlock();
        }
    }
}
//Use a critical section;
class ExplicitPairManager2 extends PairManager{
    private Lock lock=new ReentrantLock();
    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp=getPair();
        }finally {
            lock.unlock();
        }
        store(temp);
    }
}
public class ExplicitCriticalSection {
    public static void main(String[] args)throws Exception{
        PairManager pman1=new ExplicitPairManager1(),
                pman2=new ExplicitPairManager2();
        CriticalSection.testApproaches(pman1,pman2);
    }
}
