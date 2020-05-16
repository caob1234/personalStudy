package com.smart.test;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "", a = "", b = "";
        while (input.hasNextLine()) {
            a = input.nextLine();
            b = input.nextLine();
            System.out.println(check(a, b));
        }
    }

    private static int check(String a, String b) {
        char[] c = a.toCharArray();
        int j = 0;
        for (int i = 0; i < c.length; i++) {
            if (b.toLowerCase().equals(String.valueOf(c[i]).toLowerCase())) {
                j++;
            }
        }
        return j;
    }
}
