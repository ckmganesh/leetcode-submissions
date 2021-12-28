class LRUCache {
    
    Node head = new Node();
    Node tail = new Node();
    HashMap<Integer,Node> map;
    int capacity;

    class Node{
        Node next;
        Node prev;
        int key;
        int val;
    }
    
    
    public LRUCache(int capacity) {
        map = new HashMap(capacity);
        this.capacity = capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        int result=-1;
        if(map.get(key)!=null){
            Node node = map.get(key);
            result = node.val;
            remove(node);
            add(node);
        }
        
        return result;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node node = new Node();
            node.key=key;
            node.val=value;
            if(map.size()==capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
                add(node);
                map.put(key,node);
            }
            else{
                add(node);
                map.put(key,node);
            }
        }
        else{
            Node node = map.get(key);
            remove(node);
            node.val=value;
            add(node);
            map.put(key,node);
        }
    }
    
    public void add(Node node){
        Node head_next = head.next;
        node.prev = head;
        head.next=node;
        node.next=head_next;
        head_next.prev=node;
    }
    public void remove(Node node){
        Node next_node = node.next;
        Node prev_node = node.prev;
        prev_node.next=next_node;
        next_node.prev=prev_node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */