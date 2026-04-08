class FirstUnique {
    Queue<Integer> queue;
   
    Map<Integer,Integer> freq;
    
    public FirstUnique(int[] nums) {
        queue=new ArrayDeque<>();
        freq=new HashMap<>();
       
       
        for(int x:nums){
           add(x);
            
        }
        

    }
    
    public int showFirstUnique() {
        if(queue.isEmpty())
            return -1;
        while(!queue.isEmpty() && freq.get(queue.peek())>1){
            queue.poll();
        }
        return queue.isEmpty()?-1:queue.peek();
        
    }
    
    public void add(int value) {
        freq.put(value,freq.getOrDefault(value,0)+1);
        if(freq.get(value)==1)
            queue.add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
