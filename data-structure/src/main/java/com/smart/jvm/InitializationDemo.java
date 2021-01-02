package com.smart.jvm;

class School{
    static {
        System.out.println("School static code block");
    }
}
class Teacher extends  School{
    static {
        System.out.println("Teacher static code block");
    }
    public static String name="Tony";

    {
        System.out.println("Teacher common code block");
    }
    public Teacher() {
        System.out.println("I'm teacher");
    }
}
class Student extends Teacher{
    static {
        System.out.println("Student static code block");
    }
    {
        System.out.println("Student common code block");
    }

    public Student() {
        System.out.println("I'm student");
    }
}
public class InitializationDemo {
    public static void main(String[] args){
//        System.out.println("Teacher's name:"+Student.name);
        Student student=new Student();
        System.out.println("Teacher's name:"+student.name);
    }


    public InitializationDemo() {
    }

    static {
        System.out.println("main static code block");
    }
    static InitializationDemo demo=new InitializationDemo();
    {
        System.out.println("main common code block");
    }
}
