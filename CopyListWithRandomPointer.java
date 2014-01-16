/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode result = null;
        RandomListNode pre = null;
        RandomListNode running = head;
        while (running != null) {
            RandomListNode newNode = new RandomListNode(running.label);
            map.put(running, newNode);
            newNode.random = running.random;
            if (result == null) {
                result = newNode;
                pre = newNode;
            } else {
                pre.next = newNode;
                pre = pre.next;
            }
            running = running.next;
        }
        running = result;
        while (running != null) {
            if (running.random != null) {
                running.random = map.get(running.random);
            }
            running = running.next;
        }
        return result;
    }
}
