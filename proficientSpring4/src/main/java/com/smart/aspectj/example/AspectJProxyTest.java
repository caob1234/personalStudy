package com.smart.aspectj.example;

import com.smart.NaiveWaiter;
import com.smart.Waiter;
import com.smart.aspectj.aspectj.PreGreetingAspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.testng.annotations.Test;

public class AspectJProxyTest {
    @Test
    public void main(){
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(PreGreetingAspect.class);
        Waiter proxy = factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");
    }
}
