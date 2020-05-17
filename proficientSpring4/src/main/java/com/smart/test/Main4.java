package com.smart.test;


import net.mindview.util.RandomGenerator;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/*
https://www.nowcoder.com/practice/e4af1fe682b54459b2a211df91a91cf3?tpId=37&tqId=21259&tPage=2&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class Main4 {
//    private final String az
    public static void main(String[] args){
//        System.out.println(getKeyStr("AAAbbbbB"));
//        char[] chars={'A','Z'};
//        List list1=getAz();
//        List list2=covertToList("TR");
//        List list3=compareList(list1,list2);

        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String key=scanner.nextLine();
            String data=scanner.nextLine();
            System.out.println(getEncryptStr(key,data));
        }
    }
    /**
     * get A~Z
     */
    private static List getAz(){
//        char[] chars=new char[26];
        ArrayList list=new ArrayList();
        StringBuffer sb=new StringBuffer();
        for (int i=65;i<=90;i++){
            char ch= (char) i;
            list.add(ch);
        }
        return list;
    }

    private static String getEncryptStr(String key,String data){
        StringBuffer sb=new StringBuffer();
        Map map=getEncryptMap(key);
        for (Character c:data.toCharArray()){
            if (map.containsKey(c)){
                sb.append(map.get(c));
            }else {
                char dataChar = c.toString().toUpperCase().toCharArray()[0];
                if (map.containsKey(dataChar)){
                    sb.append(map.get(dataChar).toString().toLowerCase());
                }else {
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }
    /**
     * 加密
     */
    private static Map<Character, Character> getEncryptMap(String key){
        Map<Character,Character> map=new HashMap<>();
        List keyList=covertToList(getKeyStr(key));
//        keyList.stream().forEach((e)->{
//            char i=65;
//            map.put(i, (Character) e);
//            i++;
//        });
        char A=65;
        for (Object o : keyList) {
            map.put(A, (Character) o);
            A++;
        }
        char middle= (char) (65+keyList.size());
        for (Object o:compareList(getAz(),keyList)){
            map.put(middle, (Character) o);
            middle++;
        }
//        compareList(getAz(),keyList).forEach(e->{
//            char c= (char) (65+keyList.size());
//            map.put(c, (Character) e);
//            c++;
//        });
        return map;
    }
    private static List compareList(List list1,List list2){
        ArrayList list;
        list = (ArrayList) list1.stream().filter(w -> !list2.contains(w)).collect(Collectors.toList());
        return list;
    }

    private static List<Character> covertToList(String key){
        ArrayList list=new ArrayList();
        for (char ch:key.toCharArray()){
            list.add(ch);
        }
        return list;
    }
    /**
     * 去重
     */
    private static String getKeyStr(String key){
        StringBuffer sb=new StringBuffer();
        if (key==null&&key.isEmpty()){
            return key;
        }else {
            char[] chars=key.toUpperCase().toCharArray();
            ArrayList list=new ArrayList();
            for (int i = 0; i < chars.length; i++) {
                list.add(chars[i]);
            }
            list.stream().distinct().forEach((e)->{
                sb.append(e);
            });
        }
        return sb.toString();
    }
}
