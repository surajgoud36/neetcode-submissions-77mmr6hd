class Solution {
    /**
     * @param {number[]} sticks
     * @return {number}
     */
    connectSticks(sticks) {
        const minHeap = new PriorityQueue((a,b)=> a-b,sticks);
       // console.log(minHeap.front());
        let cost =0;
        while(minHeap.size() > 1){
            let curr = minHeap.dequeue() + minHeap.dequeue();
            cost+=curr;
            minHeap.enqueue(curr);
        }
        return cost;
    }
}
