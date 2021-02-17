package com.smart.algorithm.interview;

import java.util.HashMap;

/**
 * java程序员面试宝典-算法宝典——page80
 */
class pair{
    int first,second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class ArrayElements {
    boolean findPairs(int arr[]){
        HashMap<Integer,pair> sumPair=new HashMap<>();
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                int sum=arr[i]+arr[j];
                if (!sumPair.containsKey(sum)){
                    sumPair.put(sum,new pair(arr[i],arr[j]));
                }else {
                    pair p=sumPair.get(sum);
                    System.out.println("("+p.first+","+p.second+")" +
                            "("+arr[i]+","+arr[j]+")");
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int arr[]={3,4,7,10,20,9,8};
        ArrayElements arrayElements=new ArrayElements();
        arrayElements.findPairs(arr);
    }
}
