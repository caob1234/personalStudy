package com.smart.test;

public class ArrayUtil {

    public int findStartIndex(int[] dist, int[] search) throws Exception{
        int index = -1;
        int length = 0;
        for (int j = 0; j < dist.length; j++) {
            if (search[0] == dist[j]) {
                for (int i = 0; i < search.length; i++) {
                    if ((j + i) < dist.length && search[i] == dist[j + i]) {
                        length++;
                    }else {
                        break;
                    }
                }
                if (length == search.length) {
                    index = j;
                    System.out.println("start point:" + j);
                    break;
                } else {
                    System.out.println("--------:" + "-1");
                    length=0;
                    continue;
                }

            } else {
                continue;
            }
        }
        return index;
    }
    public int indexOf(int[] search,int[] dist) throws Exception{
        int number=0;
        int index = -1;
        int length = 1;
        for (int j = 0; j < dist.length; j++) {
            if (search[0] == dist[j]) {
                for (int i = 1; i < search.length; i++) {
                    int distIndex=findIndexByValue(search[i],j+i,dist);
                    if (distIndex !=-1) {
                        length++;
                        j=distIndex;
                    }else {
                        break;
                    }
                }
                if (length == search.length) {
                    index = j;
                    System.out.println("start point:" + j);
                    number++;
                    break;
                } else {
                    System.out.println("--------:" + "-1");
                    length=0;
                    continue;
                }

            } else {
                continue;
            }
        }
        return number;
    }
    public int findIndexByValue(int value,int startIndex,int[] dist){
        int index=-1;
        if (startIndex==dist.length||startIndex>dist.length){
            return index;
        }
        for (int i = startIndex+1; i < dist.length; i++) {
            if (value==dist[i]){
                index=i;
                break;
            }
        }
        return index;
    }
    public int NumberOfValue(int startIndex,int lastIndex,int value,int[] dist){
        int number=0;
        for (int i = startIndex; i < lastIndex+1; i++) {
            if (value==dist[i]){
                number++;
            }
        }
        return number;
    }
}
