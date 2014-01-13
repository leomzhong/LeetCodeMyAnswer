/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SortList {
    public ListNode mergeTwoSortedList(ListNode first, ListNode second) {
        ListNode result = null;
        ListNode pre = null;
        while (first != null && second != null) {
            if (first.val < second.val) {
                if (result == null) {
                    result = first;
                } else {
                    pre.next = first;
                }
                pre = first;
                first = first.next;
            } else {
                if (result == null) {
                    result = second;
                } else {
                    pre.next = second;
                }
                pre = second;
                second = second.next;
            }
        }
        if (first != null) {
            if (result == null) {
                result = first;
            } else {
                pre.next = first;
            }
        } else {
            if (result == null) {
                result = second;
            } else {
                pre.next = second;
            }
        }
        return result;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }
        ListNode secondHead = preSlow.next;
        preSlow.next = null;
        return mergeTwoSortedList(sortList(head), sortList(secondHead));
    }
}
