package ValidateBinarySearchTree;

import com.sun.source.tree.Tree;

public class ValidateBST2 {
    static TreeNode prev = null;

    public static boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        boolean left = isValidBST(root.left);
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;
        boolean right = isValidBST(root.right);

        return left && right;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;

            this.left = left;

            this.right = right;

        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0, null, null);
        System.out.println(isValidBST(treeNode));
    }
}
