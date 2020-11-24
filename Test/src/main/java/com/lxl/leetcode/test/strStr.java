package com.lxl.leetcode.test;

public class strStr {
    public int strStr(String haystack, String needle) {
        // 方法1：直接调用String的方法indexOf返回第一次出现的索引下表
        if (haystack == null) {
            return -1;
        }
        return haystack.indexOf(needle);
    }
}
