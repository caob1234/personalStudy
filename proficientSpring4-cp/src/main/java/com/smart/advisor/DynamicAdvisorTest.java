package com.smart.advisor;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class DynamicAdvisorTest {
    @Test
    public void dynamic(){
        String configPath = "com/smart/advisor/dynamic-advisor-test-beans.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter2");
        waiter.greetTo("Peter");
        waiter.serveTo("Peter");
        waiter.serveTo("John");
        waiter.greetTo("John");
    }
}
