/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        return Helper(num, 0, num.length - 1);
    }

    public TreeNode Helper(int[] array, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode result = new TreeNode(array[mid]);
        result.left = Helper(array, left, mid - 1);
        result.right = Helper(array, mid + 1, right);
        return result;
    }
}
