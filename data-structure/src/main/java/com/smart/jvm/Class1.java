package com.smart.jvm;
class Class2{
//    public static int getCount() {
//        return count;
//    }

    public static int count=0;
    static{
        count++;
    }

    public Class2() {
        count++;
    }
}
public class Class1 {
    public static int count=1;
    static Class1 o3=new Class1();
    static{
        count++;
    }

    public Class1() {
        count++;
    }
    public static void main(String[] args){
        Class1 o1=new Class1();
        Class1 o2=new Class1();
        System.out.println(o1.count);
    }
}
