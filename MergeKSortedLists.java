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
public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode pre = null;
        ListNode result = null;
        int index = findNext(lists);
        while (index != -1) {
            if (pre == null) {
                pre = lists.get(index);
                result = pre;
            } else {
                pre.next = lists.get(index);
                pre = pre.next;
            }
            lists.set(index, lists.get(index).next);
            index = findNext(lists);
        }

        index = 0;
        ListNode remain = null;
        while (index < lists.size()) {
            if (lists.get(index) != null) {
                remain = lists.get(index);
            }
            index++;
        }
        if (pre == null) {
            result = remain;
        } else {
            pre.next = remain;
        }
        return result;
    }

    public int findNext(ArrayList<ListNode> lists) {
        int min = Integer.MAX_VALUE;
        int result = -1;
        int counter = 0;
        for (int i = 0; i < lists.size(); i++) {
            ListNode node = lists.get(i);
            if (node != null) {
                counter++;
                if (node.val <= min) {
                    min = node.val;
                    result = i;
                }
            }
        }
        if (counter == 0 || counter == 1)
            return -1;
        else
            return result;
    }
}
