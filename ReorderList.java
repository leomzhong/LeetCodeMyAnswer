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
public class ReorderList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode second = head.next;
        ListNode first = head;
        head.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = first;
            first = second;
            second = tmp;
        }
        return first;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        secondHead = reverseList(secondHead);
        mergeList(head, secondHead);
    }

    public ListNode mergeList(ListNode headLong, ListNode headShort) {
        ListNode result = headLong;
        if (headShort == null)
            return result;
        ListNode tmp1 = headLong.next;
        headLong.next = headShort;
        headLong = tmp1;
        ListNode pre = headShort;
        headShort = headShort.next;
        while (headShort != null) {
            tmp1 = headLong.next;
            pre.next = headLong;
            headLong.next = headShort;
            headLong = tmp1;
            pre = headShort;
            headShort = headShort.next;
        }
        pre.next = headLong;
        return result;
    }
}
