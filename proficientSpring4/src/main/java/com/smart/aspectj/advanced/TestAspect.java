package com.smart.aspectj.advanced;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspect {
    @After("within(com.smart.*) " + " && execution(* greetTo(..))")
    public void greetToFun(){
        System.out.println("--greetToFun() executed--");
    }
    @Before(" !target(com.smart.NaiveWaiter) "+"&& execution(* serveTo(..))")
    public void notServeInNaiveWaiter(){
        System.out.println("--notServeInNaiveWaiter() executed--");
    }
    @AfterReturning("target(com.smart.Waiter) || "+" target(com.smart.Seller)")
    public void waiterOrSeller(){
        System.out.println("--waiterOrSeller() executed--");
    }
}
