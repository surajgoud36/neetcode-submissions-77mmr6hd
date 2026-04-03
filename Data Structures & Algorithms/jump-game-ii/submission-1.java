class Solution {
    public int jump(int[] nums) {
        // track of min index and jumps
        if(nums.length==1)
            return 0;
        int jumps=Integer.MAX_VALUE;
        int index=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=nums.length-1){
                if(index==-1){
                    index=i;
                    jumps=1;
                    nums[i]=1;
                }
                else{
                    if(i<index){
                        index=i;
                        jumps=1;
                        nums[i]=1;
                    }
                }
            }
            else{
                if(nums[i]+i>=index){
                    nums[i]=jumps+1;
                }
                else{
                    nums[i]=nums[i+nums[i]]+1;
                }
                
            }
        }
        return nums[0];
    }
}
