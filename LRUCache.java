public class LRUCache {

    public class Node {
        public int val;
        public int key;
        public Node pre;
        public Node next;
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
            this.pre = null;
            this.next = null;
        }

        public void insertAfter(Node node) {
            this.next = node.next;
            this.pre = node;
            node.next = this;
            this.next.pre = this;
        }

        public void deleteFromList() {
            this.pre.next = this.next;
            this.next.pre = this.pre;
        }
    }

    public int capacity;
    public HashMap<Integer, Node> map;
    public Node head;
    public Node tail;
    public int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(0, -1);
        this.tail = new Node(0, -1);
        head.next = tail;
        tail.pre = head;
        this.size = 0;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.deleteFromList();
            node.insertAfter(this.head);
            return node.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.deleteFromList();
            node.insertAfter(this.head);
            node.val = value;
        } else {
            if (this.size == this.capacity) {
                Node nodeToDelete = this.tail.pre;
                map.remove(nodeToDelete.key);
                nodeToDelete.deleteFromList();
                size--;
            }
            Node node = new Node(key, value);
            node.insertAfter(this.head);
            size++;
            map.put(key, node);
        }
    }
}
