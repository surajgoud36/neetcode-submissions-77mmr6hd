class Solution {
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if(sum%2!=0)
            return false;
        return helper(nums,0,sum/2);
        //return false;
    }

    public boolean helper(int[] nums,int i,int sum){
        if(sum==0)
            return true;
        if(sum<0)
            return false;
        if(i>=nums.length)
            return false;
        return helper(nums,i+1,sum)||helper(nums,i+1,sum-nums[i]);
    }
}
