class Solution {
    public int maxProfit(int[] prices) {
        int amt=0;
        boolean holding=true;
        return dfs(prices,false,amt,0);
    }

    public int dfs(int[] prices,boolean holding,int currPrice,int index){
        // out of bounds
        if(index>=prices.length)
            return 0;
        if(holding){
            // he can either sell or hold the stock
            int hold=dfs(prices,holding,currPrice,index+1);
            int sell=0;
            if(currPrice<prices[index]){
                // he can sell 
                sell=(prices[index]-currPrice)+dfs(prices,false,0,index+2);
            }
            else{
                //sell=dfs(prices,holding,currPrice,index+1);
            }
            return Math.max(hold,sell);
        }
        else{
            // not holding any stock, he can either buy the current stock or skip to next
            int skip=dfs(prices,holding,currPrice,index+1);
            int buy=dfs(prices,true,prices[index],index+1);
            return Math.max(skip,buy);
        }
    }
}
