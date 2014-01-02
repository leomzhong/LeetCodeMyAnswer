/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;
        ArrayList<TreeNode> record = new ArrayList<TreeNode>();
        record.add(root);
        while (record.size() != 0) {
            ArrayList<Integer> nextLevel = new ArrayList<Integer>();
            ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
            for (TreeNode node: record) {
                nextLevel.add(node.val);
                if (node.left != null)
                    tmp.add(node.left);
                if (node.right != null)
                    tmp.add(node.right);
            }
            result.add(0, nextLevel);
            record = tmp;
        }
        return result;
    }
}
