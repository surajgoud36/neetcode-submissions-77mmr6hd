class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(dfs(cost,dp,0,n),dfs(cost,dp,1,n));
    }
    public int dfs(int[] cost,int[] dp,int i,int n){
        if(i>=n)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        dp[i] = Math.min(dfs(cost,dp,i+2,n),dfs(cost,dp,i+1,n)) + cost[i];
        return dp[i];
    }
}
