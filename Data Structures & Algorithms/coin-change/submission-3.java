class Solution {
    public int coinChange(int[] coins, int amount) {
        //Arrays.sort(coins,);
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-2);
        return dfs(coins,amount,dp);
    }
    public int dfs(int[] coins,int amount,int[] dp){
        if(amount<0)
            return -1;
        if(amount==0)
            return 0;
        if(dp[amount]!=-2)
            return dp[amount];
        int count=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                int next=dfs(coins,amount-coins[i],dp);
                if(next!=-1)
                    count=Math.min(1+next,count);
                
            }
        }
        if(count==Integer.MAX_VALUE)
            dp[amount]=-1;
        else
            dp[amount]=count;
        return dp[amount];
    }
}
