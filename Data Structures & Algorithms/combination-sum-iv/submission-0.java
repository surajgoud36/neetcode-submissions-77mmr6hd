class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return dfs(nums,target,dp);
    }
   public int dfs(int[] nums,int rem,int[] dp){
        if(rem==0)
            return 1;
        if(dp[rem]!=-1)
            return dp[rem];
        dp[rem]=0;
        for(int i=0;i<nums.length;i++){
            if(rem-nums[i]>=0)
                dp[rem]+=dfs(nums,rem-nums[i],dp);
        }
        return dp[rem];
    }
}