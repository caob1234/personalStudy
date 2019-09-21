package com.smart.advisor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingAdvisorTest {
    public static void main(String[] args)throws Throwable{
        String configPath = "com/smart/advisor/beans.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.greetTo("Tom");
        waiter.serveTo("tom");
        seller.greetTo("John");
    }
}
