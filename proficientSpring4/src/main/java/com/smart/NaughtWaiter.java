package com.smart;

import com.smart.aspectj.anno.NeedTest;

public class NaughtWaiter implements Waiter {
    @Override
    @NeedTest
    public void greetTo(String name) {
        System.out.println("NaughtWaiter: greet to"+name+"...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("NaughtWaiter: serve to"+name+"...");
    }
}
