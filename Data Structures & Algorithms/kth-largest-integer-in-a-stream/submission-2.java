class KthLargest {
    int K;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        K=k;
        pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>K)
            pq.poll();
        return pq.peek();
    }
}
