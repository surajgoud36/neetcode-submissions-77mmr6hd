class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        //Map<Integer,Set<Integer>> pre = new HashMap<>();
        List<Integer> topo=new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        for(int[] p:prerequisites){
            int src=p[0];
            int dst=p[1];
            map.computeIfAbsent(src,k->new ArrayList<>()).add(dst);
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(map,topo,visit,i,path))
                return new int[0];
        }
        return topo.stream().mapToInt(Integer::intValue).toArray();
    }
    public boolean dfs(Map<Integer,List<Integer>> map,List<Integer> topo,Set<Integer> visit,int curr,List<Integer> path){
        if(path.contains(curr))
            return false;
        if(visit.contains(curr))
            return true;
        visit.add(curr);
        path.add(curr);
        if(map.containsKey(curr)){
            for(int x:map.get(curr)){
                if(!dfs(map,topo,visit,x,path))
                    return false;
            }
        }
        topo.add(curr);
        path.remove(Integer.valueOf(curr));
        return true;
    }
}
