/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * This solution is pretty tricky
 */
public class ConvertSortedListToBinarySearchTree {
    public ListNode first = null;
    public TreeNode sortedListToBST(ListNode head) {
        this.first = head;
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        return Helper(0, length - 1);
    }

    public TreeNode Helper(int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode leftHead = Helper(left, mid - 1);
        TreeNode parent = new TreeNode(this.first.val);
        this.first = this.first.next;
        parent.left = leftHead;
        parent.right = Helper(mid + 1, right);
        return parent;
    }
}
