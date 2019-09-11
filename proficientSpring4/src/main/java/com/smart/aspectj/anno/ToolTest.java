package com.smart.aspectj.anno;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ToolTest {
    @Test
    public void tool(){
        Class clazz = ForumService.class;

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for (Method method:methods){
            NeedTest needTest =method.getAnnotation(NeedTest.class);
            if (needTest!=null){
                if (needTest.value()){
                    System.out.println(method.getName() + " need test");
                }else {
                    System.out.println(method.getName() + " not need test");
                }
            }
        }
    }
}
