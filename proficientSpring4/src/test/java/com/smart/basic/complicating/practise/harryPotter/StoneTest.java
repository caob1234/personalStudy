package com.smart.basic.complicating.practise.harryPotter;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StoneTest {
    private Stone stone=new Stone();
    @Test
    public void breakDevilSnareTest(){
        System.out.println(stone.breakDevilSnare());
    }
}