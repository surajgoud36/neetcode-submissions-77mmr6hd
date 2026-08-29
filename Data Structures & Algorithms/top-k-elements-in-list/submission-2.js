class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
        const map = new Map();
        const pq = new PriorityQueue((a,b)=> a[0]-b[0]);
        for(const num of nums){
            let freq = (map.get(num) ?? 0) + 1;
            map.set(num,freq);
        }
        for(const [num,f] of map){
            pq.enqueue([f,num]);
            if(pq.size()>k)
                pq.dequeue();
        }

        return pq.toArray().map(n=>n[1]);
    }
}
