package com.lxl.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树
 *  深度优先
 *      前中后
 *  广度优先（层次遍历）
 */
public class SearchMethod {
    /**
     * 深度优先搜索-前序遍历
     * 递归实现
     * 根节点-左节点-右节点
     * @param root
     */
    public static void preOrderSearchRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderSearchRecursion(root.left);
        preOrderSearchRecursion(root.right);
    }

    /**
     * 深度优先搜索-中序遍历
     * 递归实现
     * 左节点-根节点-右节点
     * @param root
     */
    public static void inOrderSearchRecursion(TreeNode root) {
        if (root == null) {
            return ;
        }
        inOrderSearchRecursion(root.left);
        System.out.print(root.val + " ");
        inOrderSearchRecursion(root.right);
    }

    /**
     * 深度优先搜索-后序遍历
     * 递归实现
     * 左节点-右节点-根节点
     * @param root
     */
    public static void postOrderSearchRecursion(TreeNode root) {
        if (root == null) {
            return ;
        }
        postOrderSearchRecursion(root.left);
        postOrderSearchRecursion(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 深度优先搜索-先序遍历
     * 非递归-栈实现
     * @param root
     */
    public static void preOrderSearchByStack(TreeNode root) {
        if (root == null) {
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    /**
     * 广度优先遍历-非递归实现
     * 层次遍历
     * @param root
     */
//    public static void levelTraversal(TreeNode root) {
//        if (root == null) {
//            return ;
//        }
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        TreeNode temp = null;
//        int i = 0;
//        int j = 0;
//        while (!queue.isEmpty()) {
//            i = queue.size();
//            j = 0;
//            while (j < i) {
//                temp = queue.pop();
//                System.out.print(temp.val + " ");
//                if (temp.left != null) {
//                    queue.offer(temp.left);
//                }
//                if (temp.right != null) {
//                    queue.offer(temp.right);
//                }
//                j++;
//            }
//        }
//    }

    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return ;
        }
        System.out.println(root.val);
        if (root.left != null) {
            levelTraversal(root.left);
        }
        if (root.right != null) {
            levelTraversal(root.right);
        }
    }
}
