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
        int[] dist = {1,5,5,2,4,4,3,6,4,7,6};
        int[] search = {5, 4, 6};
//        CSNode csNode=new CSNode(1);
//        LinkedList<CSNode> next=new LinkedList<>();
//        next.add(new CSNode(10));
//        csNode.firstChild=new CSNode(4,new CSNode(7),next);
//        LinkedList<CSNode> b=new LinkedList<>();
//        b.add(new CSNode(5,new CSNode(7),next));
//        b.add(new CSNode(8,new CSNode(10)));
//        csNode.nextSibling=b;

//        CSNode csNode=new CSNode(arrayUtil.findIndexByValue(search[0],0,dist));
//        LinkedList<CSNode> secondNext=new LinkedList<>();
//        LinkedList<CSNode> threeNext=new LinkedList<>();
//        int secondIndex=arrayUtil.findIndexByValue(search[1],csNode.data,dist);
//        int secondIndex1=arrayUtil.findIndexByValue(search[1],secondIndex,dist);
//        int threeIndex=arrayUtil.findIndexByValue(search[2],secondIndex,dist);
//        int threeIndex1=arrayUtil.findIndexByValue(search[2],threeIndex,dist);
//        int threeIndex11=arrayUtil.findIndexByValue(search[2],secondIndex1,dist);
//        int threeIndex12=arrayUtil.findIndexByValue(search[2],threeIndex11,dist);
//        threeNext.add(new CSNode(threeIndex1));
//        csNode.firstChild=new CSNode(secondIndex,new CSNode(threeIndex),threeNext);
//        LinkedList<CSNode> threeNext1=new LinkedList<>();
//        threeNext1.add(new CSNode(threeIndex12));
//        secondNext.add(new CSNode(secondIndex1,new CSNode(threeIndex11),threeNext1));
//        int secondIndex2=arrayUtil.findIndexByValue(search[1],secondIndex1,dist);
//        int threeIndex21=arrayUtil.findIndexByValue(search[2],secondIndex2,dist);
//        secondNext.add(new CSNode(secondIndex2,new CSNode(threeIndex21)));
//        csNode.nextSibling=secondNext;

//        CSNode csNode=new CSNode(arrayUtil.findIndexByValue(search[0],0,dist));
//        CSNode firstChild;
//        for (int i = 1; i < search.length; i++) {
//            int index=arrayUtil.findIndexByValue(search[i],csNode.data,dist);
//            csNode.firstChild=new CSNode(index);
//            LinkedList<CSNode> nextSibling=new LinkedList<>();
//            nextSibling.add(new CSNode(arrayUtil.findIndexByValue(search[i],
//                    csNode.firstChild.data,dist)));
//            while (arrayUtil.findIndexByValue(search[i],
//                    csNode.nextSibling.get(0).data,dist)!=-1){
//                nextSibling.add(new CSNode(arrayUtil.findIndexByValue(search[1],
//                        csNode.nextSibling.get(0).data,dist)));
//            }
//            csNode.nextSibling=nextSibling;
//        }

        int rootIndex=arrayUtil.findIndexByValue(search[0],0,dist);
        ChildNode childNode=new ChildNode(rootIndex);
//        for (int i = 1; i <search.length ; i++) {
            arrayUtil.visitTree(rootIndex,search[1],search,dist,childNode);
//        }

        System.out.println(arrayUtil.indexOf(search,dist));

    }
}