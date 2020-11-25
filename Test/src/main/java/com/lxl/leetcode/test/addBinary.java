package com.lxl.leetcode.test;

import java.math.BigDecimal;

public class addBinary {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(Math.max(a.length(), b.length()) + 1);
        int k = 0;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) - 48 + b.charAt(j) - 48 + k == 2) {
                stringBuilder.append("0");
                k = 1;
            } else if (a.charAt(i) - 48 + b.charAt(j) - 48 + k == 3) {
                stringBuilder.append("1");
                k = 1;
            } else {
                stringBuilder.append(a.charAt(i) - 48 + b.charAt(j) - 48 + k);
                k = 0;
            }
            i--;
            j--;
        }
        if (i != -1) {
            while (i >= 0) {
                if (a.charAt(i) - 48 + k == 2) {
                    stringBuilder.append("0");
                    k = 1;
                } else {
                    stringBuilder.append(a.charAt(i) - 48 + k);
                    k = 0;
                }
                i--;
            }
        }
        if (j != -1) {
            while (j >= 0) {
                if (b.charAt(j) - 48 + k == 2) {
                    stringBuilder.append("0");
                    k = 1;
                } else {
                    stringBuilder.append(b.charAt(j) - 48 + k);
                    k = 0;
                }
                j--;
            }
        }
        if (k == 1) {
            return "1" + stringBuilder.reverse();
        }
        return stringBuilder.reverse().toString();
        /*
        StringBuilder stringBuilder = null;
        if (a.length() > b.length()) {
            stringBuilder = new StringBuilder(a.length());
            for (int i = 0; i < a.length() - b.length(); i++) {
                stringBuilder.append("0");
            }
            b = stringBuilder.append(b).toString();
        } else if (a.length() < b.length()) {
            stringBuilder = new StringBuilder(b.length());
            for (int i = 0; i < b.length() - a.length(); i++) {
                stringBuilder.append("0");
            }
            a = stringBuilder.append(a).toString();
        }
        int k = 0;
        StringBuilder stringBuilder1 = new StringBuilder(a.length());
        int i = a.length() - 1;
        for (; i >= 0; i--) {
            if ((b.charAt(i) - 48 + a.charAt(i) - 48 + k) == 2) {
                k = 1;
                stringBuilder1.append("0");
            } else if ((b.charAt(i) - 48 + a.charAt(i) - 48 + k) == 3) {
                k = 1;
                stringBuilder1.append("1");
            } else {
                stringBuilder1.append((b.charAt(i) - 48 + a.charAt(i) - 48 + k));
                k = 0;
            }
        }
        if (i == -1 && k == 1) {
            return "1" + stringBuilder1.reverse().toString();
        }
        return stringBuilder1.reverse().toString();

         */
    }

    public static void main(String[] args) {
//        System.out.println(addBinary(
//                "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
//                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        System.out.println(addBinary(
                "1111",
                "1111"));
    }
}
