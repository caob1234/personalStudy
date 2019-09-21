package com.smart.beanprop;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundle {
    public static void main(String[] args)throws Throwable{
        ResourceBundle rb1=ResourceBundle.getBundle("com.smart.i18n.resource",Locale.US);
        ResourceBundle rb2=ResourceBundle.getBundle("com.smart.i18n.resource",Locale.CHINA);
        System.out.println("us: "+rb1.getString("greeting.common")+"cn: "+
                rb2.getString("greeting.common"));
    }
}
