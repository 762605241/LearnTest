package com.lxl.leetcode.test;

import java.util.Arrays;

public class plusOne {
    public static int[] plusOne(int[] digits) {
        boolean flag = false;
        int i = digits.length - 1;
        for (; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                flag = true;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        if (flag && i == -1) {
            int[] digits1 = new int[digits.length + 1];
            System.arraycopy(digits, 0, digits1, 1, digits.length);
            digits1[0] = 1;
            return digits1;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
    }
}
