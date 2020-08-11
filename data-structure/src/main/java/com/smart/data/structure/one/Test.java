package com.smart.data.structure.one;
class Person{
    int age;
    int sex;
    int height;
    int weight;

    public Person(int age, int sex, int height, int weight) {
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }
}
public class Test {
    public static void main(String[] args) {
//        int max = 0;
//        changeMax(max);
//        System.out.println("max=" + max);
//        Person man=new Person(18,1,180,60);
//        changePerson(man);
//        System.out.println(man.sex+"||"+man.age);
//        String s="This value is not change";
//        changeStr(s);
//        System.out.println(s);
    }

    public  void changeStr(String s) {
        s="This value changed";
    }

    public  void changePerson(Person man) {
        man.sex=0;
        Person man1=new Person(38,1,180,60);
        man=man1;
    }

    public  void changeMax(int max) {
        max=1;
    }
}
