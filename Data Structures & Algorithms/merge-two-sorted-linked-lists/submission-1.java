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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=null,prev=null;
        while(list1!=null && list2!=null){
            //determine the smaller
            if(list1.val<=list2.val){
                if(head==null){
                    head=list1;
                    list1=list1.next;
                    prev=head;
                    continue;
                }
                prev.next=list1;
                list1=list1.next;
                prev=prev.next;
            }
            else{
                 if(head==null){
                    head=list2;
                    list2=list2.next;
                    prev=head;
                    continue;
                }
                prev.next=list2;
                prev=prev.next;
                list2=list2.next;
            }
        }
        while(list1!=null){
             if(head==null){
                    head=list1;
                    list1=list1.next;
                    prev=head;
                    continue;
                }
            prev.next=list1;
            list1=list1.next;
            prev=prev.next;
        }
        while(list2!=null){
            if(head==null){
                    head=list2;
                    list2=list2.next;
                    prev=head;
                    continue;
                }
            prev.next=list2;
            list2=list2.next;
            prev=prev.next;
        }
        return head;
    }
}