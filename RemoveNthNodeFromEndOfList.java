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
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n - 1; i++) {
            first = first.next;
            if (first == null)
                break;
        }
        if (first == null)
            return head;
        if (first.next == null)
            return head.next;
        ListNode pre = second;
        first = first.next;
        second = second.next;
        while (first.next != null) {
            first = first.next;
            second = second.next;
            pre = pre.next;
        }
        pre.next = second.next;
        return head;
    }
}
