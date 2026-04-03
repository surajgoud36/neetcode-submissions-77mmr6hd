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
        // Map of original and copy
        Map<Node,Node> map=new HashMap<>();
        Node curr=head;
        while(curr!=null){
            Node copy=new Node(curr.val);
            map.put(curr,copy);
            curr=curr.next;
        }
        curr=head;
        Node newHead=map.get(head);
        while(curr!=null){
            Node copy=map.get(curr);
            copy.next=curr.next==null?null:map.get(curr.next);
            copy.random=curr.random==null?null:map.get(curr.random);
            curr=curr.next;
        }
        return newHead;
    }
}
