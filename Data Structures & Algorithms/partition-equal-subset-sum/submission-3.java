class Solution {
     Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%2!=0)
            return false;
        int target=sum/2;
        dp = new Boolean[nums.length][target+1];
        return dfs(0,0,target,nums);
    }
    boolean dfs(int index,int sum, int target,int[] nums){
        if(sum==target)
            return true;
        if(index>=nums.length)
            return false;
        if(dp[index][sum]!=null)
            return dp[index][sum];
        dp[index][sum]=false;
        if(sum+nums[index]<=target){
            dp[index][sum]=dp[index][sum]||dfs(index+1,sum+nums[index],target,nums);

        }
        dp[index][sum]=dp[index][sum]||dfs(index+1,sum,target,nums);
        return dp[index][sum];
    }
}
