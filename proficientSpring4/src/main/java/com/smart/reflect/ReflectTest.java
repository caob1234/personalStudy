package com.smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable{
        //1.get car object via ClassLoader
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        Class clazz=loader.loadClass("com.smart.reflect.Car");

        //2.get default constructor of class and instantiate Car
        Constructor cons=clazz.getDeclaredConstructor((Class[])null);
        Car car= (Car) cons.newInstance();

        //3.set property via reflect method
        Method setBrand=clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"HQ CA72");
        Method setColor=clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"black");
        Method setMaxSpeed=clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,200);
        return car;
    }
    public static void main(String[] args) throws Throwable {
        Car car=initByDefaultConst();
        car.introduce();
    }
}
