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
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int pos=len-n;
        if(pos==0)
            return head.next;
        ListNode prev=null;
        temp=head;
        while(pos!=0){
            prev=temp;
            temp=temp.next;
            pos--;
        }
        prev.next=temp.next;
        return head;
    }
}
