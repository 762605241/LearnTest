package com.lxl.leetcode.test;

/**
 * @author 刘晓亮
 * @date 2020/11/18 11:02
 */
public class removeElement {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
//        for (int i = 0, j = nums.length - 1; i < j; ) {
//            if (nums[i] == val) {
//                nums[i] = nums[j];
//                nums[j] = val;
//                j--;
//            } else {
//                i++;
//            }
//        }
//        int i = 0;
//        for (; i < nums.length; i++) {
//            if (nums[i] == val) {
//                return i;
//            }
//        }
//        return i;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }
}
