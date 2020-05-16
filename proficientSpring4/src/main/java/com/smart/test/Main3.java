package com.smart.test;

import java.util.Scanner;

public class Main3 {
    private static int a = 0, b = 0, c = 0, d = 0, e = 0, error = 0, pri = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineContext = "";
        while (scanner.hasNextLine()) {
            lineContext = scanner.nextLine();
            check(lineContext);
            System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + error + " " + pri);
        }
    }

    private static void check(String lineContext) {
        String[] strs = lineContext.split("~");
        if (strs.length == 2) {
            String type = "";
            String[] address = strs[0].split("\\.");
            if (!checkNumber(address)) {
                error++;
                return;
            }
            int first = Integer.valueOf(address[0]).intValue();
            int second = Integer.valueOf(address[1]).intValue();
            if (address.length == 4) {
                if ((first == 10) || (first == 172 && second >= 16 && second < 32) || (first == 192 && second == 168)) {
                    type = "PRI";
                } else if (first > 0 && first < 127) {
                    type = "A";
                } else if (first > 127 && first < 192) {
                    type = "B";
                } else if (first >= 192 && first < 224) {
                    type = "C";
                } else if (first >= 224 && first < 240) {
                    type = "D";
                } else if (first >= 240 && first < 255) {
                    type = "E";
                } else {
                    System.out.println("=========" + first);
                }
            }
            String[] subnetMask = strs[1].split("\\.");//subnet mask
            if (!checkNumber(subnetMask)) {
                error++;
                return;
            }
            boolean flag = checkMaskCodeA(subnetMask);
            if (subnetMask.length == 4 && flag) {
                switch (type) {
                    case "A":
                        a++;
                        break;
                    case "B":
                        b++;
                        break;
                    case "C":
                        c++;
                        break;
                    case "D":
                        d++;
                        break;
                    case "PRI":
                        pri++;
                        break;
                }

            } else if (first != 0 && first != 127) {
                error++;
            } else {
                System.out.println("=========" + lineContext);
            }
        }
//        return a+" "+b+" "+c+" "+d+" "+e+" "+error+" "+pri;
    }

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
        boolean flag = false;
        if (checkMaskCode(subnetMask[3]) && "255".equals(subnetMask[2]) && "255".equals(subnetMask[1]) && "255".equals(subnetMask[0])) {
            flag = true;
        } else if ("0".equals(subnetMask[3]) && checkMaskCode(subnetMask[2]) && "255".equals(subnetMask[1]) && "255".equals(subnetMask[0])) {
            flag = true;
        } else if ("0".equals(subnetMask[3]) && checkMaskCode(subnetMask[1]) && "0".equals(subnetMask[2]) && "255".equals(subnetMask[0])) {
            flag = true;
        } else if ("0".equals(subnetMask[3]) && checkMaskCode(subnetMask[0]) && "0".equals(subnetMask[2]) && "0".equals(subnetMask[1])) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    private static boolean checkMaskCode(String maskCodeStr) {
        int maskCode = Integer.valueOf(maskCodeStr).intValue();
        boolean flag = false;
        int[] maskCodeArr = {128, 192, 224, 240, 248, 252, 254, 255};
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
