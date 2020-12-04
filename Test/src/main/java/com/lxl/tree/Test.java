package com.lxl.tree;

public class Test {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        // 深度-前序-递归
        SearchMethod.preOrderSearchRecursion(a);
        System.out.println();
        // 深度-前序-非递归-栈实现
        SearchMethod.preOrderSearchByStack(a);
        System.out.println();
        // 深度-前序-非递归-队列实现
        SearchMethod.preOrderSearchByQueue(a);
        System.out.println();
        // 深度-中序-递归
        SearchMethod.inOrderSearchRecursion(a);
        System.out.println();
        // 深度-后序-递归
        SearchMethod.postOrderSearchRecursion(a);
    }
}
