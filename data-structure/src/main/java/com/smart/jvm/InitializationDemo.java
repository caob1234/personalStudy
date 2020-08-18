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

    public Teacher() {
        System.out.println("I'm teacher");
    }
}
class Student extends Teacher{
    static {
        System.out.println("Student static code block");
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
}
