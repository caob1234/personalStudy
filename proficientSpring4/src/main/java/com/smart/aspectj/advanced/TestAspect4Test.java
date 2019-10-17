package com.smart.aspectj.advanced;

import com.smart.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect4Test {
    public static void main(String[] args)throws Throwable{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/" +
                "aspectj/advanced/beans4.xml");
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        naiveWaiter.greetTo("John");
    }
}
