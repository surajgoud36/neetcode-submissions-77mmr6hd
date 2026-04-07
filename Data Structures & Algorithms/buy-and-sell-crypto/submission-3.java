class Solution {
    public int maxProfit(int[] prices) {
        int l=0,h=1;
        int profit=0;
        for(h=1;h<prices.length;h++){
            profit=Math.max(prices[h]-prices[l],profit);
            if(prices[h]<prices[l])
                l=h;
        }
        return profit;
    }
}
