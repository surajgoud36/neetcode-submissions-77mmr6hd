class Solution {
    public int integerBreak(int n) {
        int max=0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        for(int i=1;i<n;i++){
            max=Math.max(max,i*dfs(n-i,dp));
        }
        return max;
        

    }

    public int dfs(int sum,int[] dp){
        if(dp[sum]!=-1)
            return dp[sum];
        dp[sum]=sum;
        for(int i=1;i<sum;i++){
            dp[sum]=Math.max(dp[sum],i*dfs(sum-i,dp));
        }
        return dp[sum];
    }
}