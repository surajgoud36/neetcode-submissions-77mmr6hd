class Solution {
    public int maxProfit(int[] prices) {
        int curr=-1;
        int profit=0;
        for(int i=0;i<prices.length-1;i++){
            if(curr==-1 && prices[i+1]>prices[i])
                curr=prices[i];
            else if(curr!=-1 && prices[i+1]<prices[i]){
                 profit+=prices[i]-curr;
                 curr=-1;
            }
               
        }
        if(curr!=-1 && curr<prices[prices.length-1])
            profit+=prices[prices.length-1]-curr;
        return profit;
    }
}