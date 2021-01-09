package com.smart.data.structure.twentyone;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author  caob
 * @version 1.0, 2020/10/12
 */
public class HashTest<K,V> {
    public static void main(String[] args){
        String s="abcd";
        String s1=new String("abcd");
        System.out.println("--------"+s.hashCode()+"-------"+getHashValue(s));
        System.out.println("dcba".hashCode());
        Map<String,String> map=new HashMap<String, String>();
        map.put("1","hello");
        map.put("2","world");
        System.out.println(map.get("1").hashCode());
        System.out.println(getHashValue("1")+"|"+"1".hashCode());
        System.out.println(map.get("1")+" "+map.get("2"));
        System.out.println(s.equals(s1));
        System.out.println(s==s1);
    }
    public static int getHashValue(String s){
        int g=31;
        int hash=0;
        int n=s.length();
        for (int i = 0; i < n; i++) {
            hash=g*hash+s.charAt(i);
        }
        return hash;
    }
//    public int getHashIndex(K key){
//        int hashIndex=key.hashCode()%hashTable.length;
//
//    }
}
