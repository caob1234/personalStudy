package com.smart.aspectj.advanced;

import com.smart.SmartSeller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect5Test {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/" +
                "aspectj/advanced/beans5.xml");
        SmartSeller seller = (SmartSeller) ctx.getBean("seller");
        seller.sell("Beer","John");
    }
}
