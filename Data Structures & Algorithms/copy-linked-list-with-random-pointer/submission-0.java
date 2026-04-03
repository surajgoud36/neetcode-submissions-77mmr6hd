/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
     public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        // make new head 
        Map<Node,Node> map = new HashMap<>();
        Node nhead = new Node(head.val);
        map.put(head,nhead);
       // nhead.next=head.next;
        //nhead.random=head.random==null?null:head.random;
        Node curr = head.next;
       // head.next=nhead;
        Node prev=nhead;
        while(curr!=null){
            Node latest=new Node(curr.val);
           // latest.next=curr.next;
           // latest.random=curr.random==null?null:curr.random;
            //curr.next=latest;
             map.put(curr,latest);
            curr=curr.next;
            prev.next=latest;
            prev=latest;
           
        }
        prev.next=null;

        Node temp=head;
        while(temp!=null){
            if(temp.random!=null){
                Node res=map.get(temp.random);
                Node real=map.get(temp);
                real.random=res;
            }
            else{
                Node real=map.get(temp);
                real.random=null;
            }
               // temp.random=temp.random.next;
            temp=temp.next;
        }
        return nhead;
    }
}
