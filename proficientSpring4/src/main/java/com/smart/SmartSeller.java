package com.smart;


public class SmartSeller implements Seller {
    @Override
    public int sell(String goods, String clientName) {
        System.out.println("sell "+goods+" to "+clientName+"...");
        return 100;
    }
    public void checkBill(int billId){
        if (billId == 1)
            throw new IllegalArgumentException("iae Exception");
        else
            throw new RuntimeException("re Exception");
    }
}
