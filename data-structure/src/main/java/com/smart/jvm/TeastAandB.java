package com.smart.jvm;

class A{
    public A() {
        System.out.println("A constructor");
    }
    {
        System.out.println("A general");
    }
    static {
        System.out.println("A static");
    }
}
class B extends A{
    public B() {
        System.out.println("B constructor");
    }
    {
        System.out.println("B general");
    }
    static {
        System.out.println("B static");
    }
}
public class TeastAandB {
    public static void main(String[] args){
        B b=new B();
    }
}
//output:
// A static
//B static
//A general
//A constructor
//B general
//B constructor
