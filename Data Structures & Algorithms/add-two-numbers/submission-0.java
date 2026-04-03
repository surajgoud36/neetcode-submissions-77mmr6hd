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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         int carry=0;
        int sum=0;
        ListNode head=null,prev=null;
        while(l1!=null && l2!=null){
            sum=l1.val+l2.val+carry;
            carry=sum/10;
            sum=sum%10;
            ListNode n=new ListNode(sum);
            if(head==null)
                head=n;
            if(prev!=null)
                prev.next=n;
            prev=n;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            sum=l1.val+carry;
            carry=sum/10;
            sum=sum%10;
            ListNode n=new ListNode(sum);
             if(prev!=null)
                prev.next=n;
            prev=n;
            l1=l1.next;
        }
        while(l2!=null){
            sum=l2.val+carry;
            carry=sum/10;
            sum=sum%10;
            ListNode n=new ListNode(sum);
             if(prev!=null)
                prev.next=n;
            prev=n;
            l2=l2.next;
        }
        if(carry!=0){
             ListNode n=new ListNode(carry);
             if(prev!=null)
                prev.next=n;
            prev=n;
        }
        // if(l1!=null)
        //     prev.next=l1;
        // if(l2!=null)
        //     prev.next=l2;
        return head;
    }
}
