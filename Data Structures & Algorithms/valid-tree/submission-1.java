class Solution {
    int gc;
    public boolean validTree(int n, int[][] edges) {
        gc=0;
        int nedges=edges.length;
         if(nedges!=n-1)
            return false;
        if(n==1)
            return true;
       
       
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] edge:edges){
            int x=edge[0];
            int y=edge[1];
            map.computeIfAbsent(x,k->new ArrayList<>()).add(y);
            map.computeIfAbsent(y,k->new ArrayList<>()).add(x);

        }

        return dfs(edges[0][0],map,new boolean[n]) && gc==n;
    }
    public boolean dfs(int node,Map<Integer,List<Integer>> map,boolean[] visited){

        visited[node]=true;
        int count=0;
        for(int x:map.get(node)){
            if(visited[x]){
                count++;
                if(count==2||x==node)
                    return false;
            }
            else{
                if(!dfs(x,map,visited))
                    return false;
            }

               
            
        }
        visited[node]=false;
        gc++;
        return true;
    }
}
