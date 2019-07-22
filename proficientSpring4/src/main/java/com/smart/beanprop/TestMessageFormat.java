package com.smart.beanprop;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * test internationalize util class
 */
public class TestMessageFormat {

    public static void main(String[] args)throws Throwable{

        String pattern1 = "{0},你好！你于{1}在工商银行存入{2}元。";
        String pattern2 = "At {1,time,short} On {1,date,long},{0} paid {2,number,currency}.";
        Object[] params = {"John",new GregorianCalendar().getTime(),1.0E3};

        String msg1 = MessageFormat.format(pattern1,params);
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);
        System.out.println(msg1);
        System.out.println(msg2);
    }
}
