class KthLargest {
    List<Integer> heap;
    int count,K;
    public KthLargest(int k, int[] nums) {
        K=k;
        heap=new ArrayList<>();
        heap.add(10001);
         count=0;
        for(int i=0;i<nums.length;i++){
            if(count<k){
                heap.add(nums[i]);
                count++;
                percolate(heap.size()-1);
            }
            else{
                if(nums[i]>heap.get(1)){
                    heap.set(1,nums[i]);
                    pdown(1);
                }
            }
        }
    }
    
    public int add(int val) {
         if(count<K){
                heap.add(val);
                count++;
                percolate(heap.size()-1);
            }
            else{
                if(val>heap.get(1)){
                    heap.set(1,val);
                    pdown(1);
                }
                
            }
            return heap.get(1);
    }

    public void percolate(int i){
        while(i>1 && heap.get(i)<heap.get(i/2)){
            int temp=heap.get(i);
            heap.set(i,heap.get(i/2));
            heap.set(i/2,temp);
            i=i/2;
        }
    }
    public void pdown(int i){
        while(2*i<heap.size()){
            if(2*i+1<heap.size() && heap.get(2*i+1)<heap.get(2*i) && heap.get(2*i+1)<heap.get(i)){
                int temp=heap.get(i);
                heap.set(i,heap.get(2*i+1));
                heap.set(2*i+1,temp);
                i=2*i+1;
            }
            else if(heap.get(2*i)<heap.get(i)){
                int temp=heap.get(i);
                heap.set(i,heap.get(2*i));
                heap.set(2*i,temp);
                i=2*i;
            }
            else
                break;
        }
    }
}
