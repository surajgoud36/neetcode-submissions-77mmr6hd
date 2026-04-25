class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        Arrays.fill(dp,-1);
        return dfs(dp,amount,coins);
    }
    public int dfs(int[] dp,int amount,int[] coins){
        if(amount==0)
            return 0;
        if(dp[amount]!=-1)
            return dp[amount];
        if(amount<coins[0])
        {
            dp[amount]=-1;
            return -1;

        }
        int min=Integer.MAX_VALUE;
        for(int coin:coins){
            if(coin<=amount){
                int next=dfs(dp,amount-coin,coins);
                if(next!=-1)
                    min=Math.min(min,next);
            }
            
        }
        dp[amount]= min==Integer.MAX_VALUE?-1:(min+1);
        return dp[amount];
    }
}
