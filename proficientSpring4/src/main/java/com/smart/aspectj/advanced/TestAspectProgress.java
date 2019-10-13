package com.smart.aspectj.advanced;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspectProgress {
    @Before("TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetTo(){
        System.out.println("--pkgGreetTo() executed!--");
    }
    @Before("!target(com.smart.NaiveWaiter) && TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetToNotNaiveWaiter(){
        System.out.println("--pkgGreetToNotNaiveWaiter() executed--");
    }
}
