class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int min=Integer.MAX_VALUE;
        int l=0,r=0;
        while(l<=r && l<prices.length && r<prices.length){
            if(prices[r]<min){
                l=r;
                min=prices[r];

            }
            else{
                profit=Math.max(profit,prices[r]-min);
            }
            r++;
        }
        return profit;
    }
}
