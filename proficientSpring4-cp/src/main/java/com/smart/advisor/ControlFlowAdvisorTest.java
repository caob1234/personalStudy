package com.smart.advisor;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ControlFlowAdvisorTest {
    @Test
    public void flow(){
        String configPath="com/smart/advisor/control-flow-advisor-beans.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        Waiter waiter = (Waiter) ctx.getBean("waiter3");
        waiterDelegate.setWaiter(waiter);
        waiter.serveTo("Perter");
        waiter.greetTo("Perter");
        waiterDelegate.service("Perter");
    }
}
