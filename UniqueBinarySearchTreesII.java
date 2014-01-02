/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class UniqueBinarySearchTreesII {
    public ArrayList<TreeNode> generateTrees(int n) {
        return Helper(1, n);
    }

    public ArrayList<TreeNode> Helper(int begin, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (begin > end) {
            result.add(null);
            return result;
        }
        for (int i = begin; i <= end; i++) {
            ArrayList<TreeNode> leftTrees = Helper(begin, i - 1);
            ArrayList<TreeNode> rightTrees = Helper(i + 1, end);
            for (TreeNode ln: leftTrees) {
                for (TreeNode rn: rightTrees) {
                    TreeNode head = new TreeNode(i);
                    head.left = ln;
                    head.right = rn;
                    result.add(head);
                }
            }
        }
        return result;
    }
}
