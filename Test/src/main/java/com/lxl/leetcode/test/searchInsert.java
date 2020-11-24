package com.lxl.leetcode.test;

public class searchInsert {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 方法1：二分搜索
        int i = 0;
        int j = nums.length - 1;
        int m = (i + j) / 2;
        while (i < j) {
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
            m = (i + j) / 2;
        }
        return i;
        /*
        // 方法二：遍历数据 比较值
        // 1 大于 2 小于 0 等于
        int preResult = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == target) {
                preResult = 0;
                return i;
            } else if (i == 0 && nums[i] > target) {
                return 0;
            } else if (nums[i] > target) {
                if (preResult == 2) {
                    return i;
                }
                preResult = 1;
            } else {
                preResult = 2;
            }
        }
        return i;
         */
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
}
