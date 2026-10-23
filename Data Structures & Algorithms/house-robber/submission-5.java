class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,-1);
        return dfs(0,nums,dp,len);
    }
    public int dfs(int i,int[] nums,int[] dp,int len){
        if(i>=len)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        dp[i] = Math.max(dfs(i+1,nums,dp,len),nums[i]+dfs(i+2,nums,dp,len));
        return dp[i];
    }
}
