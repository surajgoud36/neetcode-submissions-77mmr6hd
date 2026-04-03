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
    public void reorderList(ListNode head) {
    if(head==null || head.next==null || head.next.next==null)
        return;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode rev=reverseList(slow.next);
        slow.next=null;
        slow=head;
        while(slow!=null && rev!=null){
            ListNode temp=slow.next;
            slow.next=rev;
            if(rev==null)
                return;
            rev=rev.next;
            slow=slow.next;
            slow.next=temp;
            slow=slow.next;
        }

    }

    public ListNode reverseList(ListNode head){
        if(head==null)
            return head;
        ListNode prev=head;
        ListNode curr = head.next;
        head.next=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
