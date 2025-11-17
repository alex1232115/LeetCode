package YandexList

class ValidateBinarySearchTree {

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        val deq = ArrayDeque<TreeNode>(root.value)
        return isValidBST(deq, root, root)
    }

    private fun isValidBST(deq: ArrayDeque<TreeNode>, root: TreeNode?):Boolean  {
        if (root == null){
            for (i in 0 until root) {

            }
        } else {
            deq.addLast(root.value)
        }

        return isValidBST(deq, root.left) && isValidBST(deq, root.right) && is
    }
}