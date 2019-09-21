package com.smart.proxy;

public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }
    public void printPerformance(){
        end = System.currentTimeMillis();
        long elsape = end - begin;
        System.out.println(serviceMethod+"花费"+elsape+"毫秒");
    }
}
