package com.smart.jvm;

import java.util.ArrayList;

public class Base
{
    private String baseName = "base";
    public Base()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base ba = new Sub();
        int a =100;
        int b=50;
        int c=a---b,d=a---b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        ArrayList nums=new ArrayList();
        nums.add(5);
        nums.add(3);
        nums.add(1);
        nums.add(6);
        nums.add(0,4);
        nums.remove(1);
    }
}
