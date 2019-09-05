package com.smart.proxy;

import org.testng.annotations.Test;

public class ForumServiceTestByCGlib {
    @Test
    public void proxy(){
        CglibProxy proxy = new CglibProxy();
        //generate child class by dynamic proxy
        ForumServiceImpl forumService =
                (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(1);
        forumService.removeTopic(20);
    }
}
