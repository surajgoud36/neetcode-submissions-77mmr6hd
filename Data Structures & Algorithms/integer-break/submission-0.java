class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        int max=0;
        for(int i=1;i<n;i++){
            max=Math.max(max,i*dfs(dp,n-i));
        }
        return max;
    }

    public int dfs(int[] dp,int sum){
        if(dp[sum]!=-1)
            return dp[sum];
        dp[sum]=sum;
        for(int i=1;i<sum;i++)
            dp[sum]=Math.max(dp[sum],i*dfs(dp,sum-i));
        return dp[sum];
    }
}