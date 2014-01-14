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
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode result = null;
        ListNode first = null;
        ListNode secondHead = null;
        ListNode second = null;
        while (head != null) {
            if (head.val < x) {
                if (first == null) {
                    result = head;
                    first = head;
                } else {
                    first.next = head;
                    first = head;
                }
            } else {
                if (second == null) {
                    secondHead = head;
                    second = head;
                } else {
                    second.next = head;
                    second = head;
                }
            }
            head = head.next;
        }
        if (first == null)
            return secondHead;
        else {
            if (second != null)
                second.next = null;
            first.next = secondHead;
            return result;
        }
    }
}
