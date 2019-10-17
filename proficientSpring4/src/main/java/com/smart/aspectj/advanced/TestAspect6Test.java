package com.smart.aspectj.advanced;

import com.smart.SmartSeller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect6Test {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/" +
                "aspectj/advanced/beans6.xml");
        SmartSeller seller = (SmartSeller) ctx.getBean("seller");
        seller.checkBill(1);
    }
}
