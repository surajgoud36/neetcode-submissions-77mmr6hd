/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nhead=null,prev=null,h=head,t=head;
        int count=0;
        while(t!=null){
            count++;
            if(count%k==0){
                ListNode revHead=reverse(h,t,prev);
                if(nhead==null){
                    nhead=revHead;
                    prev=h;
                }
                else
                    prev=h;
                h=prev.next;
                t=prev.next;
            }
            else{
                t=t.next;
            }
        }
        return nhead;

    }

    public ListNode reverse(ListNode head,ListNode tail,ListNode prevNode){
        ListNode curr=head,prev=null,stop=tail.next;
        while(curr!=stop){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;

        }
        head.next=stop;
        if(prevNode!=null)
            prevNode.next=tail;
        return tail;
    }
}
