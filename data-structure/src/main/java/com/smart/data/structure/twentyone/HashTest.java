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
    private int value;
    public static void main(String[] args){
        String s="abcd";
        String s1=new String("abcd");
        System.out.println("--------"+s.hashCode()+"-------"+getHashValue(s));
        System.out.println("dcba".hashCode());
        HashMap<Object,String> map=new HashMap<Object, String>();
        map.put("1","hello");
        map.put("1","world");
        System.out.println(map.get("1"));
        System.out.println(getHashValue("1")+"|"+"1".hashCode());
        System.out.println(map.get("1")+" "+map.get("2"));
        System.out.println(s.equals(s1));
        System.out.println(s==s1);
        HashTest o1=new HashTest();
        o1.setValue(3);
        HashTest o2=new HashTest();
        o2.setValue(3);
        System.out.println(o1.hashCode()+"-------"+o2.hashCode());
        System.out.println(o1.equals(o2)+"-------"+(o1==o2));
        System.out.println(hash(s)+"-------"+hash(s1));
        HashMap<HashTest,String> map1=new HashMap<>();
        map1.put(new HashTest(),"first");
        map1.put(new HashTest(),"second");
        int i1=new HashTest().hashCode();
        int i2=i1>>>16;
        System.out.println(i1^i2);
        System.out.println(67^3);
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

    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
//    public int getHashIndex(K key){
//        int hashIndex=key.hashCode()%hashTable.length;
//
//    }
}
