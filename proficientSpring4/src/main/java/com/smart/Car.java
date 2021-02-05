package com.smart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

//1.Interface for managing bean life cycle
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;
    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("call car constructor");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setBrand(String brand){
        System.out.println("call setBrand() set properties");
        this.brand=brand;
    }
    public void introduce(){
        System.out.println("brand:"+brand+";color:"+color+";maxSpeed:"+maxSpeed);
    }

    //2.Method of BeanFactoryAware
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("call BeanFactoryAware.setBeanFactory()");
        this.beanFactory=beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("call BeanNameAware.setBeanName()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("call InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("call DisposableBean.destroy()");
    }
    public void myInit(){
        System.out.println("call myInit for init-method,setting maxSpeed is 240");
        this.maxSpeed=240;
    }
    public void myDestroy(){
        System.out.println("call destroy for destroy-method");
    }
}
