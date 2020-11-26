package com.lxl.leetcode.test;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >  nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[j] = nums2[j];
            j--;
            k--;
        }

         */

/*
        int[] num = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                num[k] = nums1[i];
                i++;
            } else {
                num[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            num[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            num[k] = nums2[j];
            j++;
            k++;
        }
        for (int c = 0; c < m + n; c++) {
            nums1[c] = num[c];
        }
        */
        /*
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }
               Arrays.sort(nums1);

         */
    }
}
