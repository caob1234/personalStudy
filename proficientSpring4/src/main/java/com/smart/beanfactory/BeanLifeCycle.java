package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory(){
        Resource res=new ClassPathResource("com/smart/beanFactory/beans1.xml");
        BeanFactory bf=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
        reader.loadBeanDefinitions(res);
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());
        Car car1= (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("red");
        Car car2= (Car) bf.getBean("car");
        //Check whether car1 and car2 point to the same reference
        System.out.println("car1==car2:"+(car1==car2));
        //Close spring container
        ((ConfigurableBeanFactory) bf).destroySingletons();
    }
    public static void main(String[] args){
        LifeCycleInBeanFactory();
    }
}
