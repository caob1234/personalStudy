package com.smart.aspectj.advanced;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect1 {
    @Around("execution(* greetTo(..)) && target(com.smart.NaiveWaiter)")
    public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("------joinPointAccess----------");
        System.out.println("args[0]:"+pjp.getArgs()[0]);
        System.out.println("signature:"+pjp.getTarget().getClass());
        pjp.proceed();
        System.out.println("------joinPointAccess----------");
    }
}
