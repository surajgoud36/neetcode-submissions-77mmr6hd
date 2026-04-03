class KthLargest {
    PriorityQueue<Integer> pq ;
    int k;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        this.k=k;
        for(int x:nums){
            add(x);
        }
    }
    
    public int add(int val) {
        if(pq.size()<k){
            pq.add(val);
            return pq.peek();
        }
        // remove the peak
        if(pq.peek()<val){
             pq.poll();
             pq.add(val);
            return pq.peek();
        }
        return pq.peek();
    }
}
