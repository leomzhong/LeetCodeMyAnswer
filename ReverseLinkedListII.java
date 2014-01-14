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
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;

        ListNode pre = null;
        if (m != 1) {
            pre = head;
            for (int i = 0; i < m - 2; i++) {
                pre = pre.next;
            }
        }
        int counter = 0;
        ListNode first = null;
        ListNode second = null;
        ListNode record = null;
        if (m == 1) {
            first = head;
        } else {
            first = pre.next;
        }
        second = first.next;
        record = second.next;

        while (second != null && counter < n - m) {
            second.next = first;
            first = second;
            second = record;
            if (record != null) {
                record = record.next;
            }
            counter++;
        }

        if (m == 1) {
            head.next = second;
            return first;
        } else {
            pre.next.next = second;
            pre.next = first;
            return head;
        }
    }
}
