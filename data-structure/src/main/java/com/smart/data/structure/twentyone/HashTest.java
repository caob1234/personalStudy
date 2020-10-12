package com.smart.data.structure.twentyone;

/**
 * <p>
 *
 * @author  caob
 * @version 1.0, 2020/10/12
 */
public class HashTest {
    public static void main(String[] args){
        String s="abcd";
        int g=31;
        int hash=0;
        int n=s.length();
        for (int i = 0; i < n; i++) {
            hash=g*hash+s.charAt(i);
        }
        System.out.println("--------"+s.hashCode()+"-------"+hash);
        System.out.println("dcba".hashCode());
    }
}
