class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] pre:prerequisites){
            int src=pre[0];
            int dst=pre[1];
            map.computeIfAbsent(src,k->new ArrayList<>()).add(dst);
        }
        List<Integer> finished=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,map,visited,path))
                return false;
        }
        return true;
    }
    public boolean dfs(int course,Map<Integer,List<Integer>> map,Set<Integer> visited,Set<Integer> path){
        if(path.contains(course))
            return false;
        if(visited.contains(course))
            return true;
        visited.add(course);
        path.add(course);
        if(map.containsKey(course)){
            for(int neigh: map.get(course)){
                if(!dfs(neigh,map,visited,path))
                    return false;
            }
        }
        path.remove(Integer.valueOf(course));
        return true;
        
    }
}
