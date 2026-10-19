class Solution {
    public boolean isBipartite(int[][] graph) {
        int vertices = graph.length;
        int[] dp = new int[vertices];
        Arrays.fill(dp,-1);
        //dp[0]=0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<vertices;i++){
            if(dp[i]==-1){
                dp[i]=0;
                 q.add(i);
                while(!q.isEmpty()){
                    int curr = q.poll();
                    int next = dp[curr] == 0? 1:0;
                    for(int nei: graph[curr]){
                        if(dp[nei]!=-1 && dp[nei] != next)
                            return false;
                        else if(dp[nei]==-1){
                            dp[nei] = next;
                            q.add(nei);
                        }
                    }
                }
            }
           
        }
        
        return true;
    }
}
