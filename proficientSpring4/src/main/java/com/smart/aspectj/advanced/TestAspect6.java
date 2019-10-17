package com.smart.aspectj.advanced;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect6 {
    @AfterThrowing(value = "target(com.smart.SmartSeller)",throwing = "iae")
    public void bindException(IllegalArgumentException iae){
        System.out.println("--------bindException()------------");
        System.out.println("exception: "+iae.getMessage());
        System.out.println("--------bindException()------------");
    }
}
