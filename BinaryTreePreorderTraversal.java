/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (stack.size() != 0 || node != null) {
            while (node != null) {
                stack.push(node);
                result.add(node.val);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return result;
    }
}
