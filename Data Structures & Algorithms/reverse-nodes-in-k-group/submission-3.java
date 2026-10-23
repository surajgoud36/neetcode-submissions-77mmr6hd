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
    public ListNode reverseKGroup(ListNode head, int k) {
        int batches = getLen(head)/k;
        ListNode prev=null;
        ListNode temp = head;
        ListNode nTail=null,nHead=null,prevTail=null,tHead=null;
        for(int i=0;i<batches;i++){
            nTail = null;
            tHead=null;
            prev=null;
            for(int j=0;j<k;j++){
                ListNode next = temp.next;
                if(prev == null)
                    nTail = temp;
                temp.next = prev;
                prev=temp;
                temp=next;
            }
            if(nHead == null)
                nHead = prev;
            if(tHead == null)
                tHead = prev;
            if(prevTail!=null)
                prevTail.next=tHead;
            nTail.next = null;
            prevTail = nTail;
        }
        if(temp!=null)
            prevTail.next = temp;
        return nHead;
    }

    public int getLen(ListNode head){
        int len=0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }
}
