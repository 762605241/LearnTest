package com.lxl.leetcode.test;

import sun.reflect.generics.tree.Tree;

import java.util.TreeSet;

public class sortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root);
        System.out.println(0 / 2);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return get(nums, 0, nums.length - 1);
    }

    private static TreeNode get(int[] nums, int i, int j) {
        if (j < i || i < 0 || j >= nums.length) {
            return null;
        }
        int mid = 0;
        if ((j - i + 1) % 2 == 0) {
            mid = (i + j) / 2 + 1;
        } else {
            mid = (i + j) / 2;
        }
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = get(nums, i, mid - 1);
        treeNode.right = get(nums, mid + 1, j);
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
