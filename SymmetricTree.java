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

/********************************************
 * Iterative solution
 *******************************************/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        LinkedList<TreeNode> left = new LinkedList<TreeNode>();
        LinkedList<TreeNode> right = new LinkedList<TreeNode>();
        left.add(root);
        right.add(root);
        while (left.size() != 0) {
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            if (!(l.left == null && r.right == null)) {
                if ((l.left == null && r.right != null) || (l.left != null && r.right == null) || (l.left.val != r.right.val))
                    return false;
                left.add(l.left);
                right.add(r.right);
            }
            if (!(l.right == null && r.left == null)) {
                if ((l.right == null && r.left != null) || (l.right != null && r.left == null) || (l.right.val != r.left.val))
                    return false;

                left.add(l.right);
                right.add(r.left);
            }

        }
        return true;
    }
}
