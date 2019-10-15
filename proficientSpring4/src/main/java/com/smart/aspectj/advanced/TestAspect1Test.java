package com.smart.aspectj.advanced;

import com.smart.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class TestAspect1Test {
    @Test
    public void main(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/" +
                "aspectj/advanced/beans.xml");
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        naiveWaiter.greetTo("John");
    }
}
