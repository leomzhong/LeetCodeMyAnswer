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
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null)
            return head;
        ListNode tmp = head;
        for (int i = 0; i < k - 1; i++) {
            tmp = tmp.next;
            if (tmp == null)
                break;
        } 
        if (tmp == null)
            return head;
        ListNode n = tmp.next;
        tmp.next = reverseKGroup(n, k);
        reverseHelper(head, k, tmp.next);
        return tmp;
    }

    public void reverseHelper(ListNode head, int k, ListNode n) {
        ListNode first = head;
        ListNode second = head.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode tmp = second;
            second = second.next;
            tmp.next = first;
            first = tmp;
        }
        head.next = n;
    }
}
