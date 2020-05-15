package com.smart.test;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s="";
        while(input.hasNextLine()){
            s=input.nextLine();
            System.out.println(unzip(s));
        }
    }
    public static String check(char c){
        if (c>=48&&c<=57){
            return "number";//This is number
        }else if (c>=97&&c<=122){
            return "lower";//This is lower
        }else {
            return null;
        }
    }
    public static String unzip(String s1) {
       String s3="";
        StringBuffer s2=new StringBuffer();
        char[] arr=s1.toCharArray();
        boolean flag=true;
        Integer i2=0;
        for (int i=0;i<arr.length;i++) {
            String checkStr=check(arr[i]);

            if (checkStr!=null){
                if (("lower").equals(checkStr)){
                    if (i2.intValue()!=0){
                        int i1=i2.intValue();
                        while (i1-->0){
                            s2.append(arr[i]);
                        }
                        i2=0;
                    }else {
                        s2.append(arr[i]);
                    }
                }else if (("number").equals(checkStr)){
                    i2=new Integer(arr[i]+"");
                }
                continue;
            }else {
                flag=false;
                break;
            }
        }
        if (flag){
            s3=s2.toString();
        }else {
            s3="!error";
        }
        return s3;
    }
}
