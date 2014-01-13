/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int result = 0;
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean leftFinish = false;
        stack.push(root);
        int current = root.val;
        while (stack.size() != 0) {
            if (!leftFinish) {
                while (stack.peek().left != null) {
                    stack.push(stack.peek().left);
                    current = current * 10 + stack.peek().val;
                }
                leftFinish = true;
            }
            if (stack.peek().right != null) {
                stack.push(stack.peek().right);
                current = current * 10 + stack.peek().val;
                leftFinish = false;
            } else {
                TreeNode tmp = null;
                if (stack.peek().left == null && stack.peek().right == null) {
                    result += current;
                }
                do {
                    tmp = stack.pop();
                    current = (current - tmp.val) / 10;
                } while (stack.size() != 0 && tmp == stack.peek().right);
            }
        }
        return result;
    }
}
