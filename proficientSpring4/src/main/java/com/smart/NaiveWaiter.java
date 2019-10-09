package com.smart;

public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter: greet to "+clientName+"...");
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("NaiverWaiter: serving to "+clientName+"...");
    }
}
