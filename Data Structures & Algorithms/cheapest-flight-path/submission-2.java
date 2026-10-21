class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        int[] temp;
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src]=0;
        // inherently a BFS exploration of all edges
        for(int i=0;i<k+1;i++){
            temp=Arrays.copyOf(price,price.length);
            for(int[] edge: flights){
                int sr = edge[0], ds = edge[1], wt = edge[2];
                if(price[sr] == Integer.MAX_VALUE)
                    continue;
                if(temp[ds]> wt+price[sr])
                    temp[ds] = wt+price[sr];
            }
            price = temp;
            
        }

       return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];

    }
}
