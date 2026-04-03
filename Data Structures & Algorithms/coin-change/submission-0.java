class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] row: dp){
            Arrays.fill(row,-2);
        }
        return coinChange(dp,coins,amount,0)==Integer.MAX_VALUE? -1:coinChange(dp,coins,amount,0);
    }
    public int coinChange(int[][] dp,int[] coins,int amount,int index){
        if(amount==0)
            return 0;
        if(index>=coins.length)
            return Integer.MAX_VALUE;
        
        
        if(dp[index][amount]!=-2)
            return dp[index][amount];
        int j=0,min=Integer.MAX_VALUE,minj=0;
        while(j*coins[index]<=amount){
            int next=coinChange(dp,coins,amount-j*coins[index],index+1);
            if(next!=Integer.MAX_VALUE){
                if(min>next+j)
                    min=next+j;
                // minj=j;
                // min=next;
            }
           j++;
           
        }
        dp[index][amount]=min;
        return dp[index][amount];
    }
}
