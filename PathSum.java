/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return Helper(root, sum);
    }

    public boolean Helper(TreeNode root, int sum) {
        if (sum == 0 && root == null)
            return true;
        else if (root == null)
            return false;
        if (root.left != null && root.right == null)
            return Helper(root.left, sum - root.val);
        else if (root.left == null && root.right != null)
            return Helper(root.right, sum - root.val);
        else
            return Helper(root.left, sum - root.val) || Helper(root.right, sum - root.val);
    }
}
