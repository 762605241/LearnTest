package com.lxl.leetcode.test;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

public class minDepth {
    public static void main(String[] args) {
        //输入：root = [3,9,20,null,null,15,7]
        //输出：2
        //输入：root = [2,null,3,null,4,null,5,null,6]
        //输出：5
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        a.right = b;
        b.right = c;
        c.right = d;
        d.right = e;
        System.out.println(minDepth(a));
    }

    public static int minDepth(TreeNode root) {
        // 深度优先
//        return getDepth(root);
        // 广度优先
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        TreeNode pop = null;
        int i = 1;
        int j = 0;
        int k = 0;
        while (!stack.isEmpty()) {
            j = stack.size();
            k = 0;
            i++;
            while (k < j) {
                pop = stack.pop();
                if (pop.right == null && pop.left == null) {
                    return i;
                } else if (pop.right != null && pop.left == null) {
                    stack.offer(pop.right);
                } else if (pop.right == null && pop.left != null) {
                    stack.offer(pop.left);
                } else {
                    stack.offer(pop.left);
                    stack.offer(pop.right);
                }
                k++;
            }
        }
        return i;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right == null) {
            return getDepth(root.left) + 1;
        } else if (root.left == null && root.right != null) {
            return getDepth(root.right) + 1;
        } else {
            int left = getDepth(root.left) + 1;
            int right = getDepth(root.right) + 1;
            return Math.min(left, right);
        }
    }

    public static class TreeNode {
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
