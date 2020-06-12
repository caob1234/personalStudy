package com.smart.test;

import org.testng.annotations.Test;

import java.util.LinkedList;


public class ArrayUtilTest {

    private ArrayUtil arrayUtil = new ArrayUtil();

//    @Test
//    public void testFindStartIndex() throws Exception {
//        int[] dist = {9, 3, 3, 5, 4, 6, 4, 3, 6, 5,4,6};
//        int[] search = {5, 4, 6};
//        System.out.println(arrayUtil.findStartIndex(dist,search));
//        int[] dist1 = {9, 3, 3, 5, 5, 6, 4, 3, 6, 5,4,6};
//        int[] search1 = {5, 4, 6};
//        System.out.println(arrayUtil.findStartIndex(dist1,search1));
//        int[] dist2 = {1,5,2,3,4,5,6};
//        int[] search2 = {5, 4, 6};
//        System.out.println(arrayUtil.findStartIndex(dist2,search2));
//        int[] dist3 = {5,4,6,2,3,4,5,6};
//        int[] search3 = {5, 4, 6};
//        System.out.println(arrayUtil.findStartIndex(dist3,search3));
//    }

    @Test
    public void testIndexOf() throws Exception {
        int[] dist = {1,5,5,2,4,4,3,6,4,7,6,3,6};
        int[] search = {5, 2};


        int rootIndex=arrayUtil.findIndexByValue(search[0],0,dist);
        ChildNode childNode=new ChildNode(rootIndex);
        arrayUtil.visitTree(rootIndex,search[1],search,dist,childNode);
        System.out.println(arrayUtil.number);
        System.out.println(arrayUtil.indexOf(search,dist));

    }
}