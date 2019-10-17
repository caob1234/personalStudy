package com.smart;

@Monitorable("11111")
public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter: greet to "+clientName+"...");
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("NaiverWaiter: serving to "+clientName+"...");
    }

    public void smile(String clientName,int times){
        System.out.println("smile to "+clientName+" "+times+" times...");
    }
}
