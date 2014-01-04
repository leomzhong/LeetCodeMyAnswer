/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode right = root.right;
        flatten(root.left);
        TreeNode left = root.left;
        if (left != null) {
            root.right = left;
            root.left = null;
            TreeNode running = left;
            while (running.right != null)
                running = running.right;
            flatten(right);
            running.right = right;
        } else {
            flatten(right);   
        }
    }
}
