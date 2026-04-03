class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         Queue<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        int[] res=new int[n-k+1];
        int l=0,r=(l+k)-1,counter=1;
        for(int i=l;i<=r;i++){
           // map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
           if(dq.isEmpty())
                dq.offer(i);
            else{
                Iterator<Integer> it=dq.iterator();
                while(it.hasNext()){
                    int val=nums[it.next()];
                    if(nums[i]>val)
                        it.remove();
                }
                dq.offer(i);
            }
        }
        res[0]=nums[dq.peek()];
        for(int i=r+1;i<n;i++){
            if(dq.peek()<=l){
                dq.poll();
            }
           
            l++;
            Iterator<Integer> it=dq.iterator();
                while(it.hasNext()){
                    int val=nums[it.next()];
                    if(nums[i]>val)
                        it.remove();
                }
                dq.offer(i);
            res[counter++]=nums[dq.peek()];
        }
        return res;
    }   
}
