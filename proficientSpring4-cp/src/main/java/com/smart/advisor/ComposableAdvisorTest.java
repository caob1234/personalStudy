package com.smart.advisor;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ComposableAdvisorTest {
    @Test
    public void main(){
        String configPath = "com/smart/advisor/compsable-advisor-beans.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter4");
        System.out.println("..........................");
        System.out.println(waiter.getClass().getDeclaredMethods().length);
        System.out.println("..........................");
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);
        waiter.serveTo("Perter");
        waiter.greetTo("Perter");
        waiterDelegate.service("Perter");
    }
}
