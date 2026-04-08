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
        return add(l1,l2,0);
        
    }
    public ListNode add(ListNode l1,ListNode l2,int carry){
        if(l1==null && l2==null && carry==0)
            return null;
        if(l1==null && l2==null && carry!=0)
            return new ListNode(carry);
        if(l1==null){
            int sum=l2.val+carry;
            carry=sum/10;
            ListNode temp=new ListNode(sum%10);
            temp.next=add(l1,l2.next,carry);
            return temp;
        }
        if(l2==null){
             int sum=l1.val+carry;
            carry=sum/10;
            ListNode temp=new ListNode(sum%10);
            temp.next=add(l1.next,l2,carry);
            return temp;
        }
         int sum=l1.val+l2.val+carry;
            carry=sum/10;
            ListNode temp=new ListNode(sum%10);
            temp.next=add(l1.next,l2.next,carry);
            return temp;
    }
}
