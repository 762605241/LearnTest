package com.lxl.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;

public class countAndSay {

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String num = countAndSay(n - 1);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            int count = 1;
            while (i < num.length() - 1 && num.charAt(i) == num.charAt(i + 1)) {
                count++;
                i++;
            }
            s.append(count);
            s.append(num.charAt(i));
        }
        return s.toString();

/*
        public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return get(2, n, "1");
        /*
        String temp = "1";
        StringBuilder strs = null;
        char tempChar;
        for (int i = 2; i <= n; i++) {
            tempChar = temp.charAt(0);
            strs = new StringBuilder();
            char[] chars = temp.toCharArray();
            for (char c : chars) {
                if (c == tempChar) {
                    strs.append(c);
                } else {
                    strs.append("_").append(c);
                    tempChar = c;
                }
            }
            String[] s = strs.toString().split("_");
            String s2 = "";
            for (String s1 : s) {
                s2 += "" + s1.length() + s1.charAt(0);
            }
            temp = s2;
        }
        return temp;
        */
    }

    /*
        private static String get(int i, int n, String pre) {
            if (i > n) {
                return pre;
            }
            char k = pre.charAt(0);
            StringBuilder s = new StringBuilder();
            StringBuilder s1 = new StringBuilder();
            for (int j = 0; j < pre.length(); j++) {
                if (pre.charAt(j) == k) {
                    s.append(pre.charAt(j));
                } else {
                    s1.append(s.length()).append(k);
                    s = new StringBuilder();
                    s.append(pre.charAt(j));
                    k = pre.charAt(j);
                }
            }
            if (k == pre.charAt(pre.length() - 1)) {
                s1.append(s.length()).append(k);
            }
            return get(i + 1, n, s1.toString());
        }
    */
    public static void main(String[] args) {
        System.out.println(countAndSay(8));
    }
}
