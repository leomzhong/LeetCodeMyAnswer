public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = head.next;
        ListNode head1 = null;
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            if (head1 != null) {
                head1.next = second;
            }
            head1 = first;
            first = first.next;
            if (first != null) {
                second = first.next;
            }
        }
        return result;
    }
}

