class Node{
    int key;
    int val;
    Node prev,next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        prev=null;
        next=null;
    }
}
class LRUCache {
    int size,capacity;
    Map<Integer,Node> map;
    Node head,tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        size=0;
        head=null;
        tail=null;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        // put the node with the key at the head
        Node curr=map.get(key);
        putAtHead(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // just modify the value
            Node curr=map.get(key);
            curr.val=value;
            putAtHead(curr);
            return;
        }
        
            // check of cache is full
            if(map.size()==capacity){
                // remove the tail
                map.remove(tail.key);
                removeNode(tail);
            }
            Node node=new Node(key,value);
            addToHead(node);
            map.put(key,node);
    }
    public void putAtHead(Node curr){
        removeNode(curr);
        addToHead(curr);
    }
    public void removeNode(Node curr){
        if(curr.prev!=null)
            curr.prev.next=curr.next;
        else
            head=curr.next;
        if(curr.next!=null)
            curr.next.prev=curr.prev;
        else
            tail=curr.prev;
    }
    public void addToHead(Node curr){
        curr.prev=null;
        curr.next=head;
        if(head!=null)
            head.prev=curr;
        head=curr;
        if(tail==null)
            tail=curr;

    }
}
