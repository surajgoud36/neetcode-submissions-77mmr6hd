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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftConnector=null;
        ListNode curr=head;
        for(int i=1;i<left;i++){
            leftConnector=curr;
            curr=curr.next;
        }
        ListNode prev=null;
        ListNode rightEnd=curr;
        for(int i=left;i<=right;i++){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        rightEnd.next=curr;
        if(leftConnector==null)
            head=prev;
        else
            leftConnector.next=prev;
        return head;
    }
}