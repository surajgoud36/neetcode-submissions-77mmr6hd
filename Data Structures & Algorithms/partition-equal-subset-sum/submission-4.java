class Solution {
    public boolean canPartition(int[] nums) {
        int total_sum=0;
        for(int x:nums){
            total_sum+=x;
        }
        if(total_sum%2!=0)
            return false;
        int target = total_sum / 2;
        Boolean[][] dp=new Boolean[nums.length][target+1];
        return dfs(0,dp,nums,target);
    }
    public boolean dfs(int index,Boolean[][] dp,int[] nums,int sum){
        if(sum==0)
            return true;
        if(index>=nums.length)
            return false;
        if(dp[index][sum]!=null)
            return dp[index][sum];
        // 2choices
        
        dp[index][sum]=dfs(index+1,dp,nums,sum);
        if(nums[index]<=sum)
            dp[index][sum]=dp[index][sum]||dfs(index+1,dp,nums,sum-nums[index]);
        return dp[index][sum];
    }
}
