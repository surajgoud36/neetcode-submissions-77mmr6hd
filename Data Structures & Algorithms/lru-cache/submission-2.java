class ListNode {
    int val;
    int key;
    ListNode next;
    ListNode prev;
    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int key,int val) {
        this.key=key;
        this.val = val;
        //this.next = next;
    }
}
class LRUCache {
    int capacity,n;
    ListNode head,tail;
    Map<Integer,ListNode> map;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        n=0;
        head=null;
        tail=null;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        this.update(map.get(key));
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val=value;
           this.update(map.get(key));
        }
        else{
            ListNode node=new ListNode(key,value);
            System.out.println("n= "+n+" capacity = "+capacity);
            if(n==capacity){
                // full capacity, need to remove the head
                map.remove(head.key);
                head=head.next;
                n--;
            }
            this.create(node);
            map.put(key,node);
        }
    }

    public void update(ListNode node){
        // if there is one node we do need to do anything 
        if((head!=tail)){
            if(node==head){
                head=head.next;
                head.prev=null;
                 tail.next=node;
                node.prev=tail;
                node.next=null;
                tail=node;
            }
            else if(node!=tail){
                node.prev.next=node.next;
                node.next.prev=node.prev;
                 tail.next=node;
                node.prev=tail;
                node.next=null;
                tail=node;
            }
            // tail.next=node;
            // node.prev=tail;
            // node.next=null;
            // tail=node;
        }
    }
    public void create(ListNode node){
        if(n==0){
            head=node;
            tail=node;
            n++;
        }
        else{
            tail.next=node;
            node.prev=tail;
            tail=node;
            n++;
        }
    }
}