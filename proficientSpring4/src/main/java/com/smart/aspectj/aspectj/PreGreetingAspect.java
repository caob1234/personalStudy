package com.smart.aspectj.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // mark as a aspect by @Aspect annotation
public class PreGreetingAspect {

    @Before("execution(* serveTo(..))")// define pointcut and advice type
    public void beforeGreeting(){//logic in advice
        System.out.println("How are you!");
    }
}
