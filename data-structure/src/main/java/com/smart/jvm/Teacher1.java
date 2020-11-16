package com.smart.jvm;

public class Teacher1 {
    public static void main(String[] args){
        staticFunction();
    }

    private static void staticFunction() {
        System.out.println("teacher static method");
    }

    static Teacher1 teacher1=new Teacher1();

    {
        System.out.println("teacher common code block");
    }

    public Teacher1() {
        System.out.println("teacher constructor");
        System.out.println("age="+age+",name="+name);
    }
    int age=24;
    static String name="Tony";
    static {
        System.out.println("teacher static code block");
    }

}
