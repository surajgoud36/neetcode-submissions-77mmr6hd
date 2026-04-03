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
        ListNode curr1=l1;
        ListNode curr2=l2;
        ListNode head=null;
        ListNode prev=null;
        while(curr1!=null && curr2!=null){
            int sum = curr1.val+curr2.val+carry;
            carry=sum/10;
            int digit=sum%10;
            System.out.println(digit);
            ListNode res=new ListNode(digit);
            if(head==null){
                head=res;
                prev=res;
                curr1=curr1.next;
                curr2=curr2.next;
                continue;
            }
            prev.next=res;
            prev=res;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        while(curr1!=null){
            int sum=curr1.val+carry;
            carry=sum/10;
            int digit=sum%10;
            ListNode res=new ListNode(digit);
            prev.next=res;
            prev=res;
            curr1=curr1.next;
        }
          while(curr2!=null){
            int sum=curr2.val+carry;
            carry=sum/10;
            int digit=sum%10;
            ListNode res=new ListNode(digit);
            prev.next=res;
            prev=res;
            curr2=curr2.next;
        }
        if(carry!=0){
            ListNode res=new ListNode(carry);
            prev.next=res;
        }
        return head;
    }
}
