package com.smart.data.structure.one;

public class Bubble {
    public static int[] bubble(int[] a){
        int length=a.length;
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j <length; j++) {
                if (a[i]>a[j]){
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }
    public static void main(String[] args){
        int[] a={3,1,2,6,4,6,9,8};
        int[] b=bubble(a);
        for (int i = 0; i <b.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
