class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> adj=new HashMap<>();
        Map<Integer,Integer> visit=new HashMap<>();
        Integer[][] dp=new Integer[n][k+2];
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge: flights){
            int s=edge[0],d=edge[1],cost=edge[2];
            adj.get(s).add(new int[]{d,cost});
        }
        int res=dfs(adj,k+1,src,0,dst,dp);
       return res==1001? -1:res;
    }
    public int dfs( Map<Integer,List<int[]>> adj,int k,int curr,int stop,int dest,Integer[][] dp){
        if(stop>=k && curr!=dest)
            return 1001;
        if(curr==dest)
            return 0;
        if(dp[curr][stop]!=null)
            return dp[curr][stop];
        int max=1001;
        for(int[] nei:adj.get(curr)){
            int node=nei[0],cost=nei[1];
            max=Math.min(max,cost+dfs(adj,k,node,stop+1,dest,dp));
        }
        dp[curr][stop]=max;
        return max;
    }
}
