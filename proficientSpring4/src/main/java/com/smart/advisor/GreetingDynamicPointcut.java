package com.smart.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("invoke matches(Method,Class) to do dynamic inspection for "+aClass.getName());
        String clientName = (String) objects[0];
        return specialClientList.contains(clientName);
    }
    private static List<String> specialClientList = new ArrayList<>();
    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }
    public  boolean matches(Method method,Class clazz){
        System.out.println("invoke matches(method,class) to do static inspection for "+clazz.getName());
        return "greetTo".equals(method.getName());
    }
}
