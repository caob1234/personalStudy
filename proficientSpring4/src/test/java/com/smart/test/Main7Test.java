package com.smart.test;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Main7Test {

    @Test
    public void testConvertToInt() {
        Main7 main7=new Main7();
        main7.convertToInt("0");
        main7.convertToInt("9");
    }
}