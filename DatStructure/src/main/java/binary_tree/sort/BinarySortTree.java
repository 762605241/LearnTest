package binary_tree.sort;

import binary_tree.TreeNode;

import java.util.Stack;

public class BinarySortTree {
    /**
     * 二叉排序树
     * 搜索方法
     *
     * @param root
     * @param target
     * @return
     */
    public static boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        System.out.println("遍历节点：" + root.value);
        if (root.value > target) {
            return search(root.left, target);
        } else if (root.value < target) {
            return search(root.right, target);
        } else {
            return true;
        }
    }

    public static TreeNode insert(TreeNode root, TreeNode target) {
        if (root == null) {
            return target;
        }
        TreeNode parentNode = root;
        TreeNode temp = root;
        while (temp != null) {
            parentNode = temp;
            if (temp.value > target.value) {
                temp = temp.left;
            } else if (temp.value < target.value) {
                temp = temp.right;
            }
        }
        if (parentNode.value > target.value) {
            parentNode.left = target;
        } else if (parentNode.value < target.value) {
            parentNode.right = target;
        }

        return root;
    }

    public static TreeNode delete(TreeNode root, TreeNode target) {
        if (root == null) {
            return null;
        }
        // 1、查询删除节点位置，及其父节点
        TreeNode head = root;
        TreeNode temp = root;
        TreeNode parentNode = root;
        boolean isLeft = false;
        while (temp != null) {
            if (temp.value > target.value) {
                parentNode = temp;
                temp = temp.left;
            } else if (temp.value < target.value) {
                parentNode = temp;
                temp = temp.right;
            } else {
                isLeft = parentNode.value > target.value;
                break;
            }
        }
        if (temp == null) {
            return head;
        }
        // 2、删除结点
        if (temp.left == null && temp.right == null) {
            if (isLeft) {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
        } else if (temp.left != null && temp.right == null) {
            if (isLeft) {
                parentNode.left = temp.left;
            } else {
                parentNode.right = temp.left;
            }
        } else if (temp.left == null && temp.right != null) {
            if (isLeft) {
                parentNode.left = temp.right;
            } else {
                parentNode.right = temp.right;
            }
        } else {
            if (head.value == parentNode.value) {
                head = parentNode.right;
            }
            // 3、将删除节点的左子树整体放在其右子树中最小节点的左子树（或右子树）
            if (isLeft) {
                parentNode.left = temp.right;
            } else {
                parentNode.right = temp.right;
            }
            // 查找删除结点右子树最小节点
            TreeNode minNode = temp.right;
            TreeNode tempMinNode = temp.right;
            while (tempMinNode != null) {
                if (tempMinNode == null) {
                    break;
                }
                minNode = temp;
                tempMinNode = tempMinNode.left;
            }
            minNode.left = temp.left;
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(7);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(9);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(8);
        TreeNode g = new TreeNode(11);
        TreeNode h = new TreeNode(1);
        TreeNode i = new TreeNode(3);
        TreeNode j = new TreeNode(10);
        /*TreeNode root = null;
        root = insert(null, a);
        TreeNode.inOrderToString(root);
        System.out.println();
        root = insert(root, b);
        TreeNode.inOrderToString(root);
        System.out.println();
        root = insert(root, c);
        TreeNode.inOrderToString(root);
        System.out.println();
        root = insert(root, d);
        TreeNode.inOrderToString(root);
        System.out.println();
        root = insert(root, e);
        TreeNode.inOrderToString(root);
        System.out.println();
        root = insert(root, f);
        TreeNode.inOrderToString(root);
        System.out.println();
        root = insert(root, g);
        TreeNode.inOrderToString(root);
        System.out.println();
        root = insert(root, h);
        TreeNode.inOrderToString(root);
        System.out.println();
        root = insert(root, i);
        TreeNode.inOrderToString(root);
        System.out.println();
        root = insert(root, j);
        TreeNode.inOrderToString(root);
        System.out.println();*/
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        g.left = j;
        delete(a, new TreeNode(4));
        TreeNode.inOrderToString(a);
//        System.out.println(search(a, 3));
    }
}
