/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean Helper(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val <= min && min != Integer.MIN_VALUE)
            return false;
        if (root.val >= max && max != Integer.MAX_VALUE)
            return false;
        return Helper(root.left, min, root.val) && Helper(root.right, root.val, max);
    }
}
