package com.smart.proxy;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTestByJDK {
    @Test
    public void proxy(){
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target
        .getClass().getInterfaces(),handler);
        proxy.removeTopic(1012);
        proxy.removeForum(10);
    }
}
