/**
 * 数据结构与算法分析java语言描述。page44,page45
 */
package com.smart.List;

import java.util.*;

public class ListTest {
    private static List<Integer> list;
    public static void makeList1(List<Integer> first, int N){
        first.clear();
        for (int i=0;i<N;i++){
            first.add(i);
        }
    }
    public static void makeList2(List<Integer> first, int N){
        first.clear();
        for (int i=0;i<N;i++){
            first.add(0,i);
        }
    }
    public static int sum(List<Integer> list,int N){
        int total =0;
        for (int i=0;i<N;i++){
            total +=list.get(i);
        }
        return total;
    }
    public static void removeEvensVer1(List<Integer> list){
        int i=0;
        while (i<list.size()){
            if (list.get(i)%2==0){
                list.remove(i);
            }else {
                i++;
            }
        }
    }
    public static void removeEvensVer3(List<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next()%2==0){
                iterator.remove();
            }
        }
    }
    public static void main(String[] args){
        list = new LinkedList<>();
        int N = 8000000;
//        Long startTime =  System.currentTimeMillis();
//        System.out.println("------addMethod--------start:"+startTime);
        makeList1(list,N);
//        Long endTime =  System.currentTimeMillis();
//        System.out.println("--------addMethod-----end:"+(endTime-startTime));
//        Long startTime2 = System.currentTimeMillis();
//        System.out.println(list.get(8));
//        Long endTime2 = System.currentTimeMillis();
//        System.out.println("--------getMethod-----end:"+(endTime2-startTime2));
//        System.out.println("--------sumMethod-------"+sum(list,N));
//        list = new LinkedList<>();
//        list.add(6);list.add(5);list.add(1);list.add(2);list.add(4);
//        for (Integer i:list){
//            System.out.print(i+" ");
//        }
        System.out.println("\n");
        Long startTime =  System.currentTimeMillis();
        removeEvensVer3(list);
        Long endTime =  System.currentTimeMillis();
//        for (Integer i:list){
//            System.out.print(i+" ");
//        }
        System.out.println("-----------removeEvensVer3-----------"+(endTime-startTime));
    }
}
