package com.smart.test;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String s="";
        while (input.hasNextLine()){
            s=input.nextLine();
//            System.out.println(s);
            String[] arr=s.split(" ");
            System.out.println(arr[arr.length-1].length());
        }
    }
}
