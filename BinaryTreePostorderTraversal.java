/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        boolean leftFinish = false;
        while (stack.size() != 0) {
            if (!leftFinish) {
                while (stack.peek().left != null) {
                    stack.push(stack.peek().left);
                }
                leftFinish = true;
            }
            if (stack.peek().right != null) {
                stack.push(stack.peek().right);
                leftFinish = false;
            } else {
                TreeNode tmp = null;
                do {
                    tmp = stack.pop();
                    result.add(tmp.val);
                } while (stack.size() != 0 && tmp == stack.peek().right);

            }
        }
        return result;
    }
}
