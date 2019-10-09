package com.smart;


public class SmartSeller implements Seller {
    @Override
    public void sell(String goods,String clientName) {
        System.out.println("sell "+goods+" to "+clientName+"...");
    }
}
