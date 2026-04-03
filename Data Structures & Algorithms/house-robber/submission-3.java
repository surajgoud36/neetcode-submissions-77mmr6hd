class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return dfs(0,dp,nums);
    }

    public int dfs(int index,int[] dp,int[] nums){
        if(index>=nums.length)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        dp[index]=Math.max(nums[index]+dfs(index+2,dp,nums),dfs(index+1,dp,nums));
        return dp[index];
    }
}
