/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<ArrayList<Integer>>();
        return Helper(root, sum, new ArrayList<Integer>());
    }

    public ArrayList<ArrayList<Integer>> Helper(TreeNode root, int sum, ArrayList<Integer> current) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = deepCopy(current);
        tmp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(tmp);
        } else {
            if (root.left != null)
                result.addAll(Helper(root.left, sum - root.val, tmp));
            if (root.right != null)
                result.addAll(Helper(root.right, sum - root.val, tmp));
        }
        return result;
    }

    public ArrayList<Integer> deepCopy(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer i: list) {
            result.add(i);
        }
        return result;
    }
}
