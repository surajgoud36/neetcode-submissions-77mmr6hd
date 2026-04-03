class Solution {
    public int countComponents(int n, int[][] edges) {
        int count=0;
        if(n==1)
            return 1;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge:edges){
            int x=edge[0];
            int y=edge[1];
            map.computeIfAbsent(x,k->new ArrayList<>()).add(y);
            map.computeIfAbsent(y,k->new ArrayList<>()).add(x);
        }
        boolean[] visited=new boolean[n];
        for(int[] edge:edges){
            if(!visited[edge[0]]){
                count++;
                dfs(map,visited,edge[0]);
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i])
                count++;
        }
        return count;
    }

    public void dfs(Map<Integer,List<Integer>> map, boolean[] visited,int node){
        visited[node]=true;
        if(map.containsKey(node)){
            for(int x:map.get(node)){
                if(!visited[x])
                    dfs(map,visited,x);
            }
        }
    }
}
