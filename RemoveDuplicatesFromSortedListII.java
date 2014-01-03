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
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = null;
        ListNode pre = null;
        ListNode running = head;
        boolean dup = false;
        while (running != null && running.next != null) {
            if (running.val != running.next.val) {
                if (pre == null) {
                    result = running;
                } 
                pre = running;
                running = running.next;
            } else {
                while (running.next != null && running.val == running.next.val)
                    running = running.next;
                running = running.next;
                if (pre != null) {
                    pre.next = running;
                }
            }
        }
        if (running != null && running.next == null) {
            if (pre == null) {
                result = running;
            } else {
                pre.next = running;
            }
        }
        return result;
    }
}
