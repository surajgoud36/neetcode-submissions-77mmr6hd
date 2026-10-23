class Solution {
    int N;
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[1]=1;
        N = n;
        return dfs(n,dp);
    }
    public int dfs(int num,int[] dp){
        if(num == 0)
            return 1;
        if(dp[num]!=-1)
            return dp[num];
        dp[num] = num == N ? 0 : num;
        for(int i=1;i<num;i++){
            dp[num] = Math.max(dp[num],dfs(i,dp)*dfs(num-i,dp));
        }
        return dp[num];
    }
}