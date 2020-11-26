package com.lxl.leetcode.test;

import java.util.HashMap;

public class climbStairs {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int i = 0;
    public static int climbStairs(int n) {
        int a = 0; // n = 1
        int b = 1; // n = 2
        for (int i = 1; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;

        /*
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            i = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, i);
            return i;
        }

         */
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
