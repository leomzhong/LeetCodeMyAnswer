/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return node;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        map.put(node.label, new UndirectedGraphNode(node.label));
        while (queue.size() != 0) {
            UndirectedGraphNode thisNode = queue.pollFirst();
            for (UndirectedGraphNode tmp: thisNode.neighbors) {
                if (map.get(tmp.label) == null) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(tmp.label);
                    map.put(tmp.label, newNode);
                    queue.add(tmp);
                }
                map.get(thisNode.label).neighbors.add(map.get(tmp.label));
            }
        }
        return map.get(node.label);
    }
}
