package com.smart.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ListNodeTest {
    ListNode<Integer> listNode = new ListNode<>(5, 2);
    @BeforeClass
    public void beforeClass() {
        if (listNode.get(2) != null) {
            listNode.add(listNode.get(2), 1);
            System.out.println(listNode.getStrs());

        }
        if (listNode.get(2) != null) {
            listNode.add(listNode.get(2), 3);
            System.out.println(listNode.getStrs());

        }
        listNode.add(listNode.get(1), 5);
        System.out.println(listNode.getStrs());
        listNode.add(listNode.get(5), 4);
        System.out.println(listNode.getStrs());
        listNode.add(listNode.get(2), 7);
        if (listNode.get(8)==null){
            listNode.add(listNode.getLastNode(),8);
        }
        listNode.add(listNode.get(8), 9);
        System.out.println(listNode.getStrs());
    }

    @Test
    public void testGetNext() {
        System.out.println("-------"+listNode.getNext(7).getE());
//        System.out.println("-------"+listNode.getNext(4).getE());
    }

    @Test
    public void testDelete() {
        listNode.delete(3);
        System.out.println("---"+listNode.getStrs()+"++++"+listNode.getLength());
        listNode.delete(4);
        System.out.println("---"+listNode.getStrs()+"++++"+listNode.getLength());
        listNode.delete(5);
        System.out.println("---"+listNode.getStrs()+"++++"+listNode.getLength());
    }
}