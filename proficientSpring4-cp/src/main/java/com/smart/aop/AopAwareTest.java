package com.smart.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AopAwareTest {

    @Test
    public void autoProxy(){
        String configPath = "com/smart/autoproxy/beans-aware.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.serveTo("John");
    }
}
