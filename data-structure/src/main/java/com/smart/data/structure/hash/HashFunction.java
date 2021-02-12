package com.smart.data.structure.hash;

public class HashFunction {
    public static int hash1(String key,int tableSize){
        int hashVal=0;
        for (int i = 0; i < key.length(); i++) {
            hashVal+=key.charAt(i);
        }
        return hashVal%tableSize;
    }
    public static int hash2(String key,int tableSize){
        return (key.charAt(0)+27*key.charAt(1)+
                729*key.charAt(2))%tableSize;
    }
}
