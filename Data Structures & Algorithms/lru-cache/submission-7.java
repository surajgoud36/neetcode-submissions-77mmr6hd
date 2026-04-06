class Node{
    Node next;
    Node prev;
    int key;
    int val;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        this.next=null;
        this.prev=null;
    }
}
class LRUCache {
    Map<Integer,Node> map;
    Node head,tail;
    int size,capacity;
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
        Node curr=map.get(key);
        removeNode(curr);
        addToTail(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr=map.get(key);
            curr.val=value;
            // remove the node
            // add the node to the tail
            removeNode(curr);
            addToTail(curr);
            return;
        }
        if(map.size()==capacity){
            map.remove(head.key);
            removeNode(head);
            size--;
        }
        Node node=new Node(key,value);
        map.put(key,node);
        addToTail(node);
        size++;
        
    }
    public void removeNode(Node curr){
        if(curr.prev!=null){
            curr.prev.next=curr.next;
        }
        else{
            head=curr.next;
        }
        if(curr.next!=null){
            curr.next.prev=curr.prev;
        }
        else{
            tail=curr.prev;
        }
        //size--;
        curr.next=null;
        curr.prev=null;
    }
    public void addToTail(Node curr){
        
        if(head==null){
            head=curr;
            tail=curr;
        }
        else{
            tail.next=curr;
            curr.prev=tail;
            tail=curr;
        }
    }
}
