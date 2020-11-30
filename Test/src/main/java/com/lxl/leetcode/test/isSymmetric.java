package com.lxl.leetcode.test;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class isSymmetric {
    public static void main(String[] args) {
//        1,2,2,3,4,4,3
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode e = new TreeNode(1);
        TreeNode g = new TreeNode(4);
        TreeNode h = new TreeNode(2);
        TreeNode j = new TreeNode(2);
        a.left = b;
        a.right = c;
        System.out.println(isSymmetric(a));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right == null || root.left == null && root.right != null) {
            return false;
        }
//        return isSymmetric(root.left, root.right);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (right == null && left == null) {
                continue;
            } else if (right == null && left != null || right != null && left == null) {
                return false;
            } else if (right.val != left.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null || left == null && right != null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
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
