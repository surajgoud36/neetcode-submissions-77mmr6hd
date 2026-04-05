class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        //buying-0
        // selling-1
        return Math.max(dfs(prices,0,0,dp),0);
    }
    public int dfs(int[] prices,int status,int i,int[][] dp){
        if(i>=prices.length)
            return 0;
        if(dp[i][status]!=-1)
            return dp[i][status];
        if(status==0){
            int skip=dfs(prices,status,i+1,dp);
            dp[i][status]=Math.max(skip,dfs(prices,1,i+1,dp)-prices[i]);
        }
        else{
            int skip = dfs(prices,status,i+1,dp);
            dp[i][status]=Math.max(skip,dfs(prices,0,i+2,dp)+prices[i]);
        }
        return dp[i][status];
    }
}
