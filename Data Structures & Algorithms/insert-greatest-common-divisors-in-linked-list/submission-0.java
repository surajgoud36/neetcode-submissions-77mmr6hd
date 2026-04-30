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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        if(head.next==null)
            return head;
        while(curr.next!=null){
            ListNode temp=curr.next;
            int a=curr.val,b=curr.next.val;
            int gcd = gcd(a,b);
            ListNode node=new ListNode(gcd);
            curr.next=node;
            node.next=temp;
            curr=temp;
        }
        // System.out.println("Gcd: "+gcd(12,3));
        // System.out.println("Gcd: "+gcd(4,6));
        // System.out.println("Gcd: "+gcd(2,1));
        return head;
    }
    public int gcd(int a,int b){
        if(a<b)
            return gcd(b,a);
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}