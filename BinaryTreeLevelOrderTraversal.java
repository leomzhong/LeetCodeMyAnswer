/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;
        ArrayList<TreeNode> first = new ArrayList<TreeNode>();
        first.add(root);
        while (first.size() != 0) {
            ArrayList<Integer> oneLevel = new ArrayList<Integer>();
            ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
            for (TreeNode node: first) {
                oneLevel.add(node.val);
                if (node.left != null)
                    tmp.add(node.left);
                if (node.right != null)
                    tmp.add(node.right);
            }
            result.add(oneLevel);
            first = tmp;
        }
        return result;
    }
}
