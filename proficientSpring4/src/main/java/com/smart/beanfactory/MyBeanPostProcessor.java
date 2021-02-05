package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            Car car= (Car) bean;
            if (car.getColor()==null){
                System.out.println("call BeanPostProcessor.postProcessBeforeInitialization," +
                        "setting black for car");
                car.setColor("black");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            Car car= (Car) bean;
            if (car.getMaxSpeed()>=200){
                System.out.println("call BeanPostProcessor.postProcessAfterInitialization," +
                        "setting 198 for maxSpeed of car");
                car.setMaxSpeed(198);
            }
        }
        return bean;
    }
}
