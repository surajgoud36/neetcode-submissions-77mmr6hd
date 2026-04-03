record Pair<K,V>(K key,V value){}
class Node{
    Node next;
    Node prev;
    int data;
    public Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class LRUCache {
    Map<Integer,Pair<Integer,Node>> map;
    int capacity;
    Node head,tail;
    int count;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=null;
        this.tail=null;
        this.count=0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
            Node curr=map.get(key).value();
            if(head!=curr){
                curr.prev.next=curr.next;
                if(curr.next!=null)
                    curr.next.prev=curr.prev;
                if(tail==curr)
                    tail=curr.prev;
                curr.prev=null;
                curr.next=head;
                head.prev=curr;
                head=curr;
            }
        return map.get(key).key();
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr=map.get(key).value();
            if(head!=curr){
                curr.prev.next=curr.next;
                if(curr.next!=null)
                    curr.next.prev=curr.prev;
                 if(tail==curr)
                    tail=curr.prev;
                curr.prev=null;
                curr.next=head;
                head.prev=curr;
                head=curr;
            }
            map.put(key,new Pair<>(value,curr));
        }
        else{
            // adding an entry
            //new node creation
            if(count==capacity){
                map.remove(tail.data);
                if(tail.prev==null){
                    tail=null;
                    head=null;
                }
                else{
                    tail.prev.next=null;
                    tail=tail.prev;
                }
                count--;
            }
            Node curr=new Node(key);
            if(head==null){
                head=curr;
                tail=curr;
            }
            else{
                curr.next=head;
                head.prev=curr;
               
                head=curr;
            }
            map.put(key,new Pair<>(value,curr));
            count++;
        }   
    }
}
