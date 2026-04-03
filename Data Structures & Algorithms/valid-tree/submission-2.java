class Solution {
    public boolean validTree(int n, int[][] edges) {
        int len=edges.length;
        if(len>=n)
            return false;
        Map<Integer,List<Integer>> map=new HashMap<>();
        if(len==0)
            return true;
        for(int[] edge:edges){
            map.computeIfAbsent(edge[0],k->new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1],k->new ArrayList<>()).add(edge[0]);
        }

        Set<Integer> visit=new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        return dfs(0,visit,cycle,map,-1) && visit.size()==n;
    }
    public boolean dfs(int node,Set<Integer> visit,Set<Integer> cycle, Map<Integer,List<Integer>> map,int parent){
        if(visit.contains(node))
            return false;
        visit.add(node);

        for(int neigh:map.get(node)){
            if(neigh!=parent){
                if(!dfs(neigh,visit,cycle,map,node))
                    return false;
            }
        }
        return true;
    }
}
