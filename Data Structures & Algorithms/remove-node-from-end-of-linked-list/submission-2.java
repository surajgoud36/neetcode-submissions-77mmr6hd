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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr=head;
        int len=0;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        int targetIndex=len-n;
        int index=0;
        ListNode prev=null;
        curr=head;
        while(index!=targetIndex){
            prev=curr;
            curr=curr.next;
            index++;
        }
        // we have link prev with curr's next
        if(prev==null && curr.next==null)
            return null;
        if(prev==null && curr.next!=null)
            return curr.next;
        prev.next=curr.next;
        return head;
    }
}
