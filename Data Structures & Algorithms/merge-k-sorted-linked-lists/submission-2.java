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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        for(int i=1;i<lists.length;i++){
            lists[i]=mergeLists(lists[i-1],lists[i]);
        }
        return lists[lists.length-1];
        
    }
    public ListNode mergeLists(ListNode h1,ListNode h2){
        if(h1==null && h2==null)
            return null;
        if(h1==null)
            return h2;
        if(h2==null)
            return h1;
        ListNode head=null,prev=null;
        while(h1!=null && h2!=null){
            if(h1.val<=h2.val){
                if(head==null){
                    head=h1;
                    prev=h1;
                }
                else{
                    prev.next=h1;
                    prev=prev.next;
                }
                h1=h1.next;
            }
            else{
                if(head==null){
                    head=h2;
                    prev=h2;
                }
                else{
                    prev.next=h2;
                    prev=prev.next;
                }
                h2=h2.next;
            }
        }
        if(h1!=null)
            prev.next=h1;
        if(h2!=null)
            prev.next=h2;
        return head;
    }
}
