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
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }

    public ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int more) {
        if (l1 == null && l2 == null) {
            if (more == 1)
                return new ListNode(1);
            else 
                return null;
        } else {
            int val1 = 0;
            int val2 = 0;
            ListNode next1 = null;
            ListNode next2 = null;
            if (l1 != null) {
                val1 = l1.val;
                next1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                next2 = l2.next;
            }
            int val = (val1 + val2 + more) % 10;
            int m = (val1 + val2 + more) / 10;
            ListNode result = new ListNode(val);
            result.next = addTwoNumbersHelper(next1, next2, m);
            return result;
        }
    }
}
