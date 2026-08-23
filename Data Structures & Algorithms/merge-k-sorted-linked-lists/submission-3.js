/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode[]} lists
     * @return {ListNode}
     */
    mergeKLists(lists) {
        const minHeap = new MinPriorityQueue((ele)=> ele.val);
        for(const head of lists){
            if(head!== null)
                minHeap.enqueue(head);
        }
        const dummy = new ListNode();
        let curr = dummy;
        while(!minHeap.isEmpty()){
            let node = minHeap.dequeue();
            curr.next = node;
            curr= curr.next;
            if(node.next!==null)
                minHeap.enqueue(node.next);
            
        }
        return dummy.next;
    }
}
