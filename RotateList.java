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
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || n == 0 || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null)
                fast = head;
        }
        if (fast == head)
            return head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        fast.next = head;
        slow.next = null;
        return tmp;

    }
}
