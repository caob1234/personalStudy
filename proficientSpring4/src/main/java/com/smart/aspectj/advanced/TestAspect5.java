package com.smart.aspectj.advanced;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect5 {
    @AfterReturning(value = "target(com.smart.SmartSeller)",returning = "retVal")
    public void bingReturnValue(int retVal){
        System.out.println("---------bingReturnValue()------------");
        System.out.println("returnValue: "+retVal);
        System.out.println("---------bingReturnValue()------------");
    }
}
