class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue=new ArrayDeque<>();
        int len=nums.length-k+1;
        int res[]=new int[len];
        System.out.println(len);
        for(int i=0;i<k;i++){
           pushItem(i,queue,nums);
        }
        res[0]=nums[queue.getFirst()];
        int l=0;
        for(int i=k;i<nums.length;i++){
            if(queue.peek() == l)
                queue.pollFirst();
            l++;
            pushItem(i,queue,nums);
            res[l]=nums[queue.peek()];
        }
        return res;
    }
    public void pushItem(int ind,Deque<Integer> dq,int[] nums){
        if(dq.isEmpty()){
                dq.push(ind);
            }
        else{
                while(!dq.isEmpty() && nums[dq.getLast()]<nums[ind])
                    dq.removeLast();
                dq.addLast(ind);
            }
    }
}
