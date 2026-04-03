class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums)
            sum+=x;
        if(sum%2!=0)
            return false;
       
        //get a subset equalling half the sum
        Boolean[][] dp=new Boolean[nums.length][(sum/2)+1];
        return dfs(nums,0,0,sum/2,dp);
    }
    public boolean dfs(int[] nums,int index,int currSum,int target,Boolean[][] dp){
        if(currSum==target)
            return true;
        if(index>=nums.length)
            return false;
        if(dp[index][currSum]!=null)
            return dp[index][currSum];
        dp[index][currSum]=false;
        if(currSum+nums[index]<=target){
            dp[index][currSum]=false||dfs(nums,index+1,currSum+nums[index],target,dp);
        }
        dp[index][currSum]=dp[index][currSum] || dfs(nums,index+1,currSum,target,dp);
        return dp[index][currSum];
    }
}
