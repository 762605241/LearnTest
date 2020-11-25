package com.lxl.leetcode.test;

public class maxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{
//                -2, 1, -3, 4, -1, 2, 1, -5, 4
                -1,-2,-3,-4,-5
        }));
    }

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
        /*
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;

         */
    }
}
