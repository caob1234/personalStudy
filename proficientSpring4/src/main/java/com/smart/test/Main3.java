package com.smart.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) throws IOException {
        int a = 0, b = 0, c = 0, d = 0, e = 0, error = 0, pri = 0;
        Scanner scanner = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineContext="";
        while (scanner.hasNextLine()) {
//        for (int i = 0; i < arrs.length; i++) {


        lineContext=scanner.nextLine();
            String[] strs = lineContext.split("~");
            if (strs.length == 2) {
                String[] address = strs[0].split("\\.");
                String[] subnetMask = strs[1].split("\\.");//subnet mask
                if (subnetMask.length==4&&checkNumber(subnetMask)&&checkMaskCodeA(subnetMask)) {
                    if (checkNumber(address)  ) {
                        int first = Integer.valueOf(address[0]).intValue();
                        int second = Integer.valueOf(address[1]).intValue();
                        if (first > 0 && first < 127) {
                            a++;
                            if (first == 10) {
                                pri++;
                            }
                        } else if (first > 127 && first < 192) {
                            b++;
                            if (first == 172 && second >= 16 && second < 32) {
                                pri++;
                            }
                        } else if (first >= 192 && first < 224) {
                            c++;
                            if (first == 192 && second == 168) {
                                pri++;
                            }
                        } else if (first >= 224 && first < 240) {
                            d++;
                        } else if (first >= 240 && first < 255) {
                            e++;
                        }
                    } else {
                        error++;
                    }
                } else {
                    error++;
                }
            }
            System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + error + " " + pri);
        }
    }

//    private static void check(String lineContext) {
//        String[] strs = lineContext.split("~");
//        if (strs.length == 2) {
//            String[] address = strs[0].split("\\.");
//            String[] subnetMask = strs[1].split("\\.");//subnet mask
//            boolean flag = checkMaskCodeA(subnetMask);
//            if (address.length == 4&&subnetMask.length == 4&&checkNumber(address)&&checkNumber(subnetMask) && flag) {
//                int first = Integer.valueOf(address[0]).intValue();
//                int second = Integer.valueOf(address[1]).intValue();
//                if ((first == 10) || (first == 172 && second >= 16 && second < 32) || (first == 192 && second == 168)) {
//                    pri++;
//                }
//                if (first >0 && first < 127) {
//                    a++;
//                } else if (first > 127 && first < 192) {
//                    b++;
//                } else if (first >= 192 && first < 224) {
//                    c++;
//                } else if (first >= 224 && first < 240) {
//                    d++;
//                } else if (first >= 240 && first < 255) {
//                    e++;
//                } else {
//                    if (first!=0&&first!=127){
//                        error++;
//                    }
//                }
//            }else {
//                error++;
//            }
//        }
//    }

    private static boolean checkNumber(String[] address) {
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
            } else {
                b = false;
                break;
            }
        }
        return b;
    }

    private static boolean checkMaskCodeA(String[] subnetMask) {
        boolean flag ;
        if (checkMaskCode(subnetMask[0])&&"0".equals(subnetMask[1])
                &&"0".equals(subnetMask[2])&&"0".equals(subnetMask[3])){
            flag=true;
        } else if ("255".equals(subnetMask[0])&&checkMaskCode(subnetMask[1])
                &&"0".equals(subnetMask[2])&&"0".equals(subnetMask[3])){
            flag=true;
        }else if ("255".equals(subnetMask[0])&&"255".equals(subnetMask[1])
                &&checkMaskCode(subnetMask[2])&&"0".equals(subnetMask[3])){
            flag=true;
        }else if ("255".equals(subnetMask[0])&&"255".equals(subnetMask[1])
                &&"255".equals(subnetMask[2])&&checkMaskCode(subnetMask[3])){
            if ("255".equals(subnetMask[3])){
                flag=false;
            }else {
                flag=true;
            }
        }else {
            flag=false;
        }
        return flag;
    }

    private static boolean checkMaskCode(String maskCodeStr) {
        int maskCode = Integer.valueOf(maskCodeStr).intValue();
        boolean flag = false;
        int[] maskCodeArr = {255,128, 192, 224, 240, 248, 252, 254};
//        Arrays.stream(maskCodeArr).forEach((ma)->{
//            if (maskCode==ma){
//                flag=true;
//            }
//        });
        for (int i = 0; i < maskCodeArr.length; i++) {
            if (maskCode == maskCodeArr[i]) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
