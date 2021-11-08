class LRUCache {

    private int cap;
    private HashMap<Integer,Node> map;
    private DoubleList cache; 

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        moveToHead(key);
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(cache.size()+1>cap){
                removeTail();
            }
            Node node = new Node(key,value);
            map.put(key,node);
            cache.addFirst(node);
        }else{
            Node node = map.get(key);
            node.value = value;
            moveToHead(key);
        }
     
    }

    private void moveToHead(int key){
        Node node = map.get(key);
        cache.remove(node);
        cache.addFirst(node);
    }

    private void removeTail(){
        Node deleteNode = cache.removeLast();
        map.remove(deleteNode.key);
    }




}

class Node{
    public int key;
    public int value;
    public Node pre;
    public Node next;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString(){
        return key+"_"+value;
    }
}

class DoubleList{
    private Node head,tail; // 头尾假节点
    private int size;
    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        this.size = 0;
    }

    public void addFirst(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        size++;
    }

    public void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
        size--;
    }

    public Node removeLast(){
        if(tail.pre == head) return null;
        Node last = tail.pre;
        remove(last);
        return last;
    }

    public int size(){
        return size;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
