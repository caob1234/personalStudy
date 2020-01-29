package com.smart.basic.complicating;

public class SerialNumberGenerator {
    private static volatile int serialNumber=0;
    public static synchronized int nestSerialNumber(){
        return serialNumber++;//Not thread-safe
    }
}
