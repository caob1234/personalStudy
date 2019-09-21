package com.smart.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

public class BeforeAdviceTest {
    @Test
    public void before() {
        Waiter waiter = new NativeWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(waiter);
        proxyFactory.addAdvice(advice);
        Waiter proxy = (Waiter) proxyFactory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
}
