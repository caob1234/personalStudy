package com.smart.algorithm.interview.two;

import java.util.HashMap;
import java.util.Map;
/**
 * java程序员面试宝典-算法宝典——page78
 */
public class Itinerary {
    private static void printResult(Map<String,String> input){
        Map<String,String> reverseInput=new HashMap<>();
        for (Map.Entry<String,String> entry:input.entrySet()){
            reverseInput.put(entry.getValue(),entry.getKey());
        }
        String start=null;
        for (Map.Entry<String,String> entry:input.entrySet()){
            if (!reverseInput.containsKey(entry.getKey())){
                start=entry.getKey();
                break;
            }
        }
        if (start==null){
            System.out.print("Unreasonable input");
            return;
        }
        String to=input.get(start);
        System.out.print(start+"->"+to);
        while (input.get(to)!=null){
            System.out.print(","+to+"->"+input.get(to));
            to=input.get(to);
        }
    }
    public static void main(String[] args){
        Map<String,String> input=new HashMap<>();
        input.put("Xian","ChengDu");
        input.put("Beijing","Shanghai");
        input.put("Dalian","Xian");
        input.put("Shanghai","Dalian");
        printResult(input);
    }
}
