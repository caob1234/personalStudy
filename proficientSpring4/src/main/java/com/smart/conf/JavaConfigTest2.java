package com.smart.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class JavaConfigTest2 {
    @Test
    public void main(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/smart/conf/beans2.xml");
        LogonService logonService = ctx.getBean(LogonService.class);
        logonService.printHello();
    }
}
