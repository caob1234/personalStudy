package com.smart.basic.complicating.practise.harryPotter;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;

import static org.testng.Assert.*;

public class StoneTest {
    private Stone stone=new Stone();
    @Test
    public void breakDevilSnareTest() throws ExecutionException, InterruptedException {
        System.out.println(stone.breakDevilSnare());
    }
}