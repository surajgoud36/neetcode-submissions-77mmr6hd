class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // adjacency list
        Map<Integer,List<Integer>> adj = new HashMap<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for(int[] pre:prerequisites){
            int src=pre[0];
            int dst = pre[1];
            adj.computeIfAbsent(src,k->new ArrayList<>()).add(dst);
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,adj,visit,path))
                return false;
        }
        return true;
    }
    public boolean dfs(int i,Map<Integer,List<Integer>> map,Set<Integer> visit,Set<Integer> path){
        if(path.contains(i))
            return false;
        if(visit.contains(i))
            return true;
        path.add(i);
        if(map.containsKey(i)){
            for(int neigh:map.get(i)){
                if(!dfs(neigh,map,visit,path))
                    return false;
            }
        }
        path.remove(Integer.valueOf(i));
        visit.add(i);
        return true;
    }
}
