class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int smallest=prices[0];
        for(int i=1;i<prices.length;i++){
            max=Math.max(max,prices[i]-smallest);
            smallest=Math.min(smallest,prices[i]);
        }
        return max;
    }
}
