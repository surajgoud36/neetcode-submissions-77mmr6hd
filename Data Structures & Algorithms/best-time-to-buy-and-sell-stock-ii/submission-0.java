class Solution {
    public int maxProfit(int[] prices) {
        Integer[] dp=new Integer[prices.length];
        return findMax(prices,false,0,0,dp);

    }
    public int findMax(int[] prices,boolean hold,int index,int curr,Integer[] dp){
        if(index>=prices.length)
            return 0;
        if(hold){
            // when holding a stock options 1) sell and buy 2)sell and skip 3)skip
            int profit=prices[index]-curr;
            return Math.max(findMax(prices,hold,index+1,curr,dp),profit+findMax(prices,!hold,index,0,dp));
        }
        else{
            if(dp[index]!=null)
                return dp[index];
            int max=Math.max(findMax(prices,hold,index+1,0,dp),findMax(prices,!hold,index+1,prices[index],dp));
            dp[index]=max;
            return max;
        }
    }
}