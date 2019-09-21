package com.smart.advisor;

import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class GreetingComposablePointcut {
    public static Pointcut getIntersectionPointcut(){
        ComposablePointcut composablePointcut = new ComposablePointcut();
        Pointcut pointcut = new ControlFlowPointcut(WaiterDelegate.class,"service");
        NameMatchMethodPointcut nameMatchMethodPointcut=new NameMatchMethodPointcut();
        nameMatchMethodPointcut.addMethodName("greetTo");
        return composablePointcut.intersection(pointcut).intersection((MethodMatcher) nameMatchMethodPointcut);
    }
}
