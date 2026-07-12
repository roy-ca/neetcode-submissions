class LRUCache {

    class Node {
        int key, value;
        Node next, prev;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);

            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        }
        else {
            if(map.size() == capacity) {
                Node node = tail.prev;
                remove(node);
                map.remove(node.key);
            }

            Node newNode = new Node(key, value);
            addToHead(newNode);
            map.put(key, newNode);
        }
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        remove(node);
        addToHead(node);
    }
}
