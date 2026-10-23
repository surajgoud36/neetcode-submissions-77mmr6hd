class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(dp,0,n);
    }
    public int dfs(int[] dp,int i,int n){
        if(i==n)
            return 1;
        if(i>n)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        dp[i] = dfs(dp,i+1,n) + dfs(dp,i+2,n);
        return dp[i];
    }
}
