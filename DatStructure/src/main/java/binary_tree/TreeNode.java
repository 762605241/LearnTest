package binary_tree;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int value) {
        this.value = value;
    }

    /**
     * 二叉树中序遍历
     * @param root
     */
    public static void inOrderToString(TreeNode root) {
        if (root == null) {
            return ;
        }
        inOrderToString(root.left);
        System.out.print(root.value + "\t");
        inOrderToString(root.right);
    }
}
