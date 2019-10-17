package com.smart.aspectj.advanced;

import com.smart.Monitorable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspect4 {
    @Before("@within(m)")
    public void bindTypeAnnoObject(Monitorable m){
        System.out.println("--------bindTypeAnnoObject()----------");
        System.out.println(m.getClass().getDeclaredMethods()[0]);
        System.out.println(m.getClass().getName());
        System.out.println("--------bindTypeAnnoObject()----------");
    }
}
