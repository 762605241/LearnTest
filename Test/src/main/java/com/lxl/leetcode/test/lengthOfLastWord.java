package com.lxl.leetcode.test;

public class lengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (num != 0) {
                    return num;
                }
            } else {
                num++;
            }
        }
        return num;
//        String[] s1 = s.split(" ");
//        if (s1 == null || s1.length == 0) {
//            return 0;
//        }
//        return s1[s1.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world"));
    }
}
