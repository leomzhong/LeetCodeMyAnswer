/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode curr = root;
        TreeNode first1 = null;
        TreeNode first2 = null;
        TreeNode second1 = null;
        TreeNode second2 = null;
        while (stack.size() != 0 || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (pre == null) {
                pre = curr;
            } else {
                if (pre.val > curr.val) {
                    if (first1 == null) {
                        first1 = pre;
                        first2 = curr;
                    } else if (second1 == null) {
                        second1 = pre;
                        second2 = curr;
                    }
                }
                pre = curr;
            }
            curr = curr.right;
        }
        if (second1 == null) {
            swap(first1, first2);
        } else {
            swap(first1, second2);
        }
    }

    public void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
