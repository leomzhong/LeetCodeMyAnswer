/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        Helper(root, result);
        return result[0];
    }

    public int Helper(TreeNode root, int[] result) {
        if (root == null)
            return 0;
        int left = Helper(root.left, result);
        int right = Helper(root.right, result);
        int a = root.val;
        if (left > 0)
            a += left;
        if (right > 0)
            a += right;
        result[0] = Math.max(result[0], a);
        if (left < 0 && right < 0)
            return root.val;
        else
            return root.val + Math.max(left, right);
    }
}
