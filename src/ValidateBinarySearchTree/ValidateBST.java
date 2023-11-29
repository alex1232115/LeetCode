package ValidateBinarySearchTree;

public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        if (root == null ) return true;

        Integer leftMax = findLeftMax(root);
        Integer rightMin = findRightMin(root);

        if ((leftMax != null && leftMax >= root.val) || (rightMin != null && rightMin <= root.val)){
            return false;
        }
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);

        return left && right;
    }

    private static Integer findRightMin(TreeNode root) {
        if (root.right != null) {
            root = root.right;
        } else return null;
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }

    private static Integer findLeftMax(TreeNode root) {
        if (root.left != null) {
            root = root.left;
        } else return null;
        while (root.right != null){
            root = root.right;
        }
        return root.val;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;

            this.left = left;

            this.right = right;

        }
    }
}
