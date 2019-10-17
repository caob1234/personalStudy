package com.smart.aspectj.advanced;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspect2 {
    @Before("target(com.smart.NaiveWaiter) && args(name,num,..)")
    public void bindJoinPointParams(int num,String name){
        System.out.println("-----bindJoinPointParams()--------");
        System.out.println("name:"+name);
        System.out.println("num:"+num);
        System.out.println("-----bindJoinPointParams()--------");
    }
}
