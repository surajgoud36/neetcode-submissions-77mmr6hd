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
        // handle endge cases first
        if (lists.length == 0)
            return null;
        ListNode head = null, prev = null;
        boolean nxt = false;
        int min = 0;
        do {
            // it could be null
            nxt = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    continue;
                else {
                    nxt = true;
                    if (lists[min] == null) {
                        min = i;
                    } else {
                        if (lists[i].val < lists[min].val) {
                            min = i;
                        }
                    }

                }
            }
            if (!nxt)
                break;
            if (head == null) {
                head = lists[min];
                prev = head;
                lists[min] = lists[min].next;
                continue;
            }

            prev.next = lists[min];
            prev = lists[min];
            lists[min] = lists[min].next;

        } while (nxt);
        return head;
    }
}
