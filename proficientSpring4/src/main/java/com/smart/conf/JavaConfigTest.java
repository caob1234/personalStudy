package com.smart.conf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

public class JavaConfigTest {
    @Test
    public void main(){
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(DaoConfig.class);
//        ctx.register(ServiceConfig.class);
        ctx.register(ServiceConfigC.class);
        ctx.refresh();
        LogonService logonService = ctx.getBean(LogonService.class);
        logonService.printHello();
        UserDao userDao = ctx.getBean(UserDao.class);
        System.out.println(userDao.printName("Trump"));
        DaoConfig daoConfig = ctx.getBean(DaoConfig.class);
        System.out.println(daoConfig.userDao().printName("Tom"));
    }
}
