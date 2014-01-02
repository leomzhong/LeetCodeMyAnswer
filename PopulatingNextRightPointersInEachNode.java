/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root;
        while (node != null) {
            TreeLinkNode running = node;
            TreeLinkNode last = null;
            while (running != null) {
                if (running.left != null) {
                    if (last != null) {
                        last.next = running.left;
                        last = last.next;
                    } else
                        last = running.left;
                } 
                if (running.right != null) {
                    if (last != null) {
                        last.next = running.right;
                        last = last.next;
                    } else
                        last = running.right;
                }
                running = running.next;
            }
            node = getNextLevelBegin(node);
        }
    }

    public TreeLinkNode getNextLevelBegin(TreeLinkNode root) {
        while (root != null) {
            if (root.left != null)
                return root.left;
            else if (root.right != null)
                return root.right;
            else
                root = root.next;
        }
        return null;
    }
}
