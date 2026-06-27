/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int count=0;
        ListNode tempA=headA;
        ListNode tempB = headB;
        while(count<3){
            if(tempA==tempB)
                return tempA;
            tempA=tempA.next;
            tempB=tempB.next;

            if(tempA==null){
                count++;
                tempA=headB;
            }
            if(tempB==null){
                count++;
                tempB=headA;
            }
        }
        return null;
    }
}