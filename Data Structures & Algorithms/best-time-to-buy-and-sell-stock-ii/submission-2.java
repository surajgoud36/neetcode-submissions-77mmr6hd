class Solution {
    public int maxProfit(int[] prices) {
        int rows=prices.length;
        Integer[][] dp = new Integer[rows][2];
        // hold - 1, not_hold-0
        return Math.max(dfs(prices,dp,0,0),0);
    }
    public int dfs(int[] prices,Integer[][] dp,int index,int hold){
        if(index>=prices.length)
            return 0;
        if(dp[index][hold]!=null)
            return dp[index][hold];
        if(hold == 1){
            // holding some other stock in the back
            // keep holding or sell it 

            // case 1 keep holding
            int case1 = dfs(prices,dp,index+1,hold);
            //case 2 sell it
            int case2 = dfs(prices,dp,index,0) + prices[index];
            dp[index][hold] = Math.max(case1,case2);
        }
        else{
            // not holding a stock, he can either skip this one or purchase it
            // case 1, skip
            int case1 = dfs(prices,dp,index+1,hold);
            //case 2 , buy it
            int case2 = dfs(prices,dp,index+1,1) - prices[index];
            dp[index][hold] = Math.max(case1,case2);
        }
        return dp[index][hold];
    }
}