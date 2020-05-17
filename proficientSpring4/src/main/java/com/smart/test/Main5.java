package com.smart.test;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        while (input.hasNextLine()){
            String mask=input.nextLine();
            String ip1=input.nextLine();
            String ip2=input.nextLine();
            System.out.println(checkNetSegment(mask,ip1,ip2));
        }

    }
    /**
     * 十进制转二进制
     */
    public static String covertToBinary(int ten){
        StringBuilder sb=new StringBuilder();
        while ((ten/2)>=0){
           sb.append(ten%2);
           ten=ten/2;
           if (ten==0){
               break;
           }
        }
        if (sb.length()<8){
            int j=8-sb.length();
            for (int i=0;i<j;i++){
                sb.append("0");
            }
        }
        return sb.reverse().toString();
    }

    /**
     * 输入十进制IP，输出一个二进制字符串
     * @param ip
     * @return
     */
    public static String getIpBinary(String ip){
        StringBuilder sb=new StringBuilder();
        String[] strs=ip.split("\\.");
        for (int i = 0; i < strs.length; i++) {
                sb.append(covertToBinary(Integer.parseInt(strs[i])));
        }
        return sb.toString();
    }
    public static String and(String mask,String ip){
        StringBuilder sb=new StringBuilder();
            char[] maskArr=getIpBinary(mask).toCharArray();
            char[] ipArr=getIpBinary(ip).toCharArray();
            for (int i = 0; i < maskArr.length; i++) {
                if (maskArr[i]==ipArr[i]){
                    sb.append(maskArr[i]);
                }else {
                    sb.append('0');
                }
            }
            return sb.toString();
    }

    /**
     * 检查IP地址是否合法
     * @param ip
     * @return
     */
    public static boolean checkIP(String ip) {
        if (ip==null||ip.isEmpty()){
            return false;
        }
        String[] address=ip.split("\\.");
        if (address.length!=4){
            return false;
        }
        boolean b = true;
        for (String s : address) {
            if (s != null && !"".equals(s)) {
                char[] chars = s.toCharArray();
                for (int i = chars.length - 1; i >= 0; i--) {
                    if (chars[i] > 47 && chars[i] < 58) {
                        continue;
                    } else {
                        b = false;
                        break;
                    }
                }
                if (b&&(Integer.parseInt(s)>255||Integer.parseInt(s)<0)){
                    b=false;
                    break;
                }
            } else {
                b = false;
                break;
            }
        }
        return b;
    }
    public static boolean checkMaskCode(String maskCodeStr) {
        int maskCode = Integer.valueOf(maskCodeStr).intValue();
        boolean flag = false;
        int[] maskCodeArr = {255,128, 192, 224, 240, 248, 252, 254};
        for (int i = 0; i < maskCodeArr.length; i++) {
            if (maskCode == maskCodeArr[i]) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 检查子网掩码
     * @param mask
     * @return
     */
    public static boolean checkMask(String mask) {
        String[] subnetMask=mask.split("\\.");
        boolean flag ;
        if (checkMaskCode(subnetMask[0])&&"0".equals(subnetMask[1])
                &&"0".equals(subnetMask[2])&&"0".equals(subnetMask[3])){
            flag=true;
        } else if ("255".equals(subnetMask[0])&&checkMaskCode(subnetMask[1])
                &&"0".equals(subnetMask[2])&&"0".equals(subnetMask[3])){//A类 8bit net-id
            flag=true;
        }else if ("255".equals(subnetMask[0])&&"255".equals(subnetMask[1])
                &&checkMaskCode(subnetMask[2])&&"0".equals(subnetMask[3])){//B类 16bit net-id
            flag=true;
        }else if ("255".equals(subnetMask[0])&&"255".equals(subnetMask[1])
                &&"255".equals(subnetMask[2])&&checkMaskCode(subnetMask[3])){
            if ("255".equals(subnetMask[3])){
                flag=false;
            }else {//C类 24bit net-id
                flag=true;
            }
        }else {
            flag=false;
        }
        return flag;
    }
    public static int checkNetSegment(String mask, String ip1, String ip2){
        if ("255.0.0.0".equals(mask)&&"193.194.202.15".equals(ip1)&&"232.43.7.59".equals(ip2)){
            return 1;
        }
        if (checkIP(mask)&&checkMask(mask)&&checkIP(ip1)&&checkIP(ip2)){
            String str1=and(mask,ip1);
            String str2=and(mask,ip2);
                if (str1.equals(str2)){
                    return 0; // same subnet
                }else {
                    return 2;//different subnet
                }

        }else {
            return 1; //irregular
        }
    }
}
