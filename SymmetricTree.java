/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return Helper(root.left, root.right);
    }

    public boolean Helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 == null || root2 == null)
            return false;
        else if (root1.val != root2.val)
            return false;
        else {
            return Helper(root1.right, root2.left) && Helper(root1.left, root2.right);
        }
    }
}
