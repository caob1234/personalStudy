package com.smart.normal.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestTreeSet {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args){
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();
        for(int i=606;i<613;i++){
            if(i%2==0){
                set.add(i);
            }
        }
        subSet = (TreeSet)set.subSet(608,true,611,true);
        set.add(629);
        System.out.println(set+" "+subSet);
        Map map=new TreeMap();
        map.put(1,"hello");
        map.put(2,"world");
        HashMap hashMap=new HashMap();
        hashMap.put(1,"hashMap");
        Object o=new Object();
        System.out.println(o.hashCode());
    }
}
