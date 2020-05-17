package com.smart.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Main5Test {


    @Test
    public void testCovertToBinary() {
        Main5.covertToBinary(255);
    }

    @Test
    public void testGetIpBinary() {
        Main5.getIpBinary("2.0.0.1");
    }

//    @Test
//    public void testAnd() {
//    }
//
//    @Test
//    public void testCheckIP() {
//    }
//
//    @Test
//    public void testCheckMaskCode() {
//    }
//
//    @Test
//    public void testCheckMask() {
//    }
//
    @Test
    public void testCheckNetSegment() {
        System.out.println(Main5.checkNetSegment("255.0.0.0" ,"193.194.202.15" ,"232.43.7.59"));
    }
}