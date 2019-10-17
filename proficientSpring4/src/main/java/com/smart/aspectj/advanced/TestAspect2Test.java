package com.smart.aspectj.advanced;

import com.smart.NaiveWaiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect2Test {
    public static void main(String[] args)throws Throwable{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/" +
                "aspectj/advanced/beans2.xml");
        NaiveWaiter naiveWaiter = (NaiveWaiter) ctx.getBean("naiveWaiter");
        naiveWaiter.smile("John",2);
    }
}
