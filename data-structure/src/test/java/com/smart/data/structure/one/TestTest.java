package com.smart.data.structure.one;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestTest {
    com.smart.data.structure.one.Test t;

    @BeforeMethod
    public void setUp() {
        t=new com.smart.data.structure.one.Test();
    }

    @Test
    public void testChangeStr() {
        int max = 0;
        t.changeMax(max);
        System.out.println("max=" + max);

    }

    @Test
    public void testChangePerson() {
        Person man=new Person(18,1,180,60);
        t.changePerson(man);
        System.out.println(man.sex+"||"+man.age);

    }

    @Test
    public void testChangeMax() {
        String s="This value is not change";
        t.changeStr(s);
        System.out.println(s);
    }
}