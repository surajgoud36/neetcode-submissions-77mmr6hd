class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices=new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src]=0;
        int[] temp;
        for(int i=0;i<k+1;i++){
            temp=prices.clone();
            for(int[] edge: flights){
                int s=edge[0],d=edge[1],price=edge[2];
                if(prices[s]==Integer.MAX_VALUE)
                    continue;
                if(prices[s]+price<temp[d])
                    temp[d]=prices[s]+price;
                
         }
         prices=temp;
        }
        if(prices[dst]==Integer.MAX_VALUE)
            return -1;
        return prices[dst];
        
    }
}
