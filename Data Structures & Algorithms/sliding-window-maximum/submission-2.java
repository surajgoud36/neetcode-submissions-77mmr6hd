class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         Deque<Integer> dq=new LinkedList<>();
        int n=nums.length;
        int[] res=new int[n-k+1];
        int l=0,r=(l+k)-1,counter=1;
        for(int i=l;i<=r;i++){
           // map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
           if(dq.isEmpty())
                dq.offer(i);
            else{
                 while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                    dq.removeLast();
            }
                dq.addLast(i);
            }
        }
        res[0]=nums[dq.peek()];
        for(int i=r+1;i<n;i++){
            if(dq.peek()<=l){
                dq.removeFirst();
            }
           
            l++;
             while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                    dq.removeLast();
             }
                dq.addLast(i);
            res[counter++]=nums[dq.peek()];
        
        }
        return res;
    }   
}
