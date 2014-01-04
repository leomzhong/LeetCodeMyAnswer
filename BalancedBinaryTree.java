/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int result = Helper(root);
        if (result == -1)
            return false;
        return true;
    }

    public int Helper(TreeNode root) {
        if (root == null)
            return 0;
        int first = Helper(root.left);
        if (first == -1)
            return -1;
        int second = Helper(root.right);
        if (second == -1 || Math.abs(first - second) > 1)
            return -1;
        return 1 + Math.max(first, second);
    }
}
