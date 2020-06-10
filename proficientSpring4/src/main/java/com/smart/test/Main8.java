package com.smart.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int count=input.nextInt();
        int[] arr=new int[count];
        for (int i = 0; i < count; i++) {
            arr[i]=input.nextInt();
        }

        ArrayList list=new ArrayList();
        get(arr,1,list);
        System.out.println(list.get(0));
    }
    public static int get(int[] arr,int t,ArrayList list){

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>=arr.length-1){
                list.add(t);
                t=1;
                break;
            }else if (arr[i]<arr.length){
                int j=1;

                while ( j <arr[i] ) {
                    int[] secondArr=new int[arr.length-j];
                    for (int k = 0; k < arr.length-j; k++) {
                        secondArr[k]=arr[j+k];
                    }
                    j++;
                    t++;
                    get(secondArr,t,list);
                }
            }
        }
        return t;
    }
}
