/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return Helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode Helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, HashMap<Integer, Integer> map) {
        if (preLeft > preRight)
            return null;

        TreeNode result = new TreeNode(preorder[preLeft]);
        if (preLeft == preRight)
            return result;
        int head = preorder[preLeft];
        int posInOrder = map.get(head);
        result.left = Helper(preorder, preLeft + 1, preLeft + posInOrder - inLeft, inorder, inLeft, posInOrder - 1, map);
        result.right = Helper(preorder, preLeft + posInOrder - inLeft + 1, preRight, inorder, posInOrder + 1, inRight, map);
        return result;
    }
}
