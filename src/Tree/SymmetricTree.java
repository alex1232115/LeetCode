package Tree;

import MaximumDepthOfBinaryTree.TreeNode;


public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        TreeNode root2 = new TreeNode(
                1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric(root2));
    }

    public static boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        return left.val == right.val &&
                dfs(left.left, right.right) &&
                dfs(left.right, right.left);
    }
}
