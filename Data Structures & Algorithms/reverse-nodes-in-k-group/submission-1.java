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
        int n=0;
        ListNode temp=head,finalHead=null;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        ListNode previ=null,nxt;
        // if(n-k==0)
        //     nxt=null;
        // else
        nxt=head.next;
        ListNode start=head,end=head;
        int count=1;
        while(true){
            if((n-count)+1==(n%k)){
                // breaking condition
                break;
            }
            else if(count%k==0){
                // need to reverse 
                reverse(start,end,previ,nxt);
                if(previ==null)
                    finalHead=end;
                previ=start;
                start=nxt;
                end=nxt;
                if(nxt==null)
                    break;
                nxt=nxt.next;
                count++;
            }
            else{
                end=end.next;
                nxt=nxt.next;
                count++;
            }
        }
        return finalHead;
    }

    public void reverse(ListNode start,ListNode end,ListNode previ,ListNode nxt){
        ListNode temp=null,prev=null,curr=null;
        do{
            prev=temp;
            if(temp==null)
                temp=start;
            else
                temp=curr;
            curr=temp.next;
            temp.next=prev;
            prev=temp;
        }while(temp!=end);
        // end and temp are same
        if(previ!=null)
            previ.next=temp;
        start.next=nxt;
        
    }
}
