class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        for(int i=0;i<=amount;i++)
            dp[i]=amount+1;
        dp[0]=0;
        for(int i=coins.length-1;i>=0;i--){
            int curr[]=new int[amount+1];
            for(int j=0;j<=amount;j++){
                curr[j]=dp[j];
                if(j>=coins[i]){
                    int prev=curr[j-coins[i]];
                    // if(prev==amount+1)
                    //     prev=0;
                     curr[j]=Math.min(curr[j],1+prev);
                }
                   
            }
            dp=curr;
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
