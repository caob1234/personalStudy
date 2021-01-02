package com.smart.jvm;

public class Teacher1 {
    public static void main(String[] args){
        staticFunction();
    }

    private static void staticFunction() {
        System.out.println("teacher static method");
        System.out.println("sex:"+sex);
    }

    static Teacher1 teacher1=new Teacher1();

    static {
        System.out.println("teacher static code block");
    }

    {
        System.out.println("teacher common code block");
    }
    int age=24;
    final static String name="Tony";
    static String sex="boy";
    public Teacher1() {
        System.out.println("teacher constructor");
        System.out.println("age="+age+",name="+name+",sex="+sex);
    }

}
//out:teacher common code block
//teacher constructor
//age=24,name=Tony,sex=null
//teacher static code block
//teacher static method
