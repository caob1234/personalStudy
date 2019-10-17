package com.smart.aspectj.advanced;

import com.smart.Waiter;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspect3 {
    @Before("this(waiter)")
    public void bindProxyObj(Waiter waiter){
        System.out.println("------bindProxyObj()---------");
        System.out.println(waiter.getClass().getName());
        System.out.println("------bindProxyObj()---------");
    }
}
