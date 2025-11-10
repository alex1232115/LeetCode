package YandexList

var ti = TreeNode(5)
var v = ti.value

class TreeNode(var value : Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class SymmetricTree {

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return checkSymmetric(root.left, root.right)
    }

    private fun checkSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        } else if (left != null && right != null) {
            return left.value == right.value && checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left)
        }
        return false
    }
}