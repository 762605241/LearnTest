package com.lxl.leetcode.test;

public class maxDepth {
    public static void main(String[] args) {

    }
    int max = 1;
    int i = 1;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }


        return 0;
    }

    public static int getChildDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == root) {

        }
        int left = getChildDepth(root.left);
        int right = getChildDepth(root.right);

        return left > right ? left : right;


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
