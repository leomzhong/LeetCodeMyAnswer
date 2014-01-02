/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode pre = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (pre == null) {
                    result = l1;
                } else {
                    pre.next = l1;
                }
                pre = l1;
                l1 = l1.next;
            } else {
                if (pre == null) {
                    result = l2;
                } else {
                    pre.next = l2;
                }
                pre = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            if (pre == null) {
                result = l1;
            } else
                pre.next = l1;
        } else {
            if (pre == null) {
                result = l2;
            } else
                pre.next = l2;
        }
        return result;
    }
}
