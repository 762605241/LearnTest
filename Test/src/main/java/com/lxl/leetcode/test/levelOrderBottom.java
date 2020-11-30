package com.lxl.leetcode.test;


import java.util.*;

public class levelOrderBottom {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        System.out.println(levelOrderBottom(a));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        TreeNode temp = null;
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int size = 0;
        List<Integer> tempList = null;
        while (!list.isEmpty()) {
            size = list.size();
            i = 0;
            tempList = new ArrayList<>(size);
            for (; i < size; i++) {
                temp = list.pop();
                tempList.add(temp.val);
                if (temp.left != null) {
                    list.offer(temp.left);
                }
                if (temp.right != null) {
                    list.offer(temp.right);
                }
            }
            result.add(0, tempList);
        }
        return result;
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
