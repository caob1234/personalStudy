package com.smart.aspectj.fun;

import com.smart.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class PointcutFunTest {
    @Test
    public void pointcut(){
        String configpath="com/smart/aspectj/fun/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configpath);
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        naiveWaiter.greetTo("Tom");
        Waiter naughtWaiter= (Waiter) ctx.getBean("naughtWaiter");
        naughtWaiter.greetTo("John");
    }
}
