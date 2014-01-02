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
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode first = head;
        ListNode second = head;
        do {
            first = first.next.next;
            second = second.next;
        } while (first != null && first.next != null && first != second);
        if (first != second)
            return null;
        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
