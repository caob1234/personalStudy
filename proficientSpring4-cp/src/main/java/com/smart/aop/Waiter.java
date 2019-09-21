package com.smart.aop;

public class Waiter implements BeanSelfProxyAware {
    private Waiter waiter;
    @Override
    public void setSelfProxy(Object object) {
        waiter = (Waiter) object;
    }
    public void serveTo(String name){
        System.out.println("waiter serving "+name+"...");
        greetTo(name);
    }

    private void greetTo(String name) {
        System.out.println("waiter greet to "+name+"...");
    }
}
