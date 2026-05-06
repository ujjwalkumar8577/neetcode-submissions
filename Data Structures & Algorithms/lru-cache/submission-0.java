class LRUCache {
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }
        Node node = new Node(key, value);
        addToHead(node);
        map.put(key, node);
        if (map.size() > capacity) {
            removeLRU();
        }
    }

    public void removeNode(Node node) {
        node.prev.next= node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public void removeLRU() {
        Node lru = tail.prev;
        removeNode(lru);
        map.remove(lru.key);
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}