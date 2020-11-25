package com.lxl.leetcode.test;

public class mySqrt {
    public static int mySqrt(int x) {
//        return (int) Math.sqrt(x);
        double i = 0;
        while ((i * i) <= x)
            i += 0.1;
        for (int j = 0; j < 10; j++) {
            i = (x / i + i) / 2;
        }
        return (int) i;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}
