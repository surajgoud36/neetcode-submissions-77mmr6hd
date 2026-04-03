class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
        this.next=null;
    }
}
class MyCircularQueue {
    Node head,tail;
    int len,size;

    public MyCircularQueue(int k) {
        this.size=0;
        this.len=k;
        head=null;
        tail=null;
    }
    
    public boolean enQueue(int value) {
        Node node=new Node(value);
        if(isFull())
            return false;
        if(head==null){
            head=node;
            tail=node;
            size++;
            return true;
        }
        tail.next=node;
        tail=node;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        Node temp=head.next;
        head.next=null;
        head=temp;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return head.val;
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        if(size==0)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if(size==len)
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */