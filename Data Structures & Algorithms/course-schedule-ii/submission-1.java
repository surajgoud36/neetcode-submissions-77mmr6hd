class Solution {
    List<Integer> res;
    Set<Integer> over;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       res=new ArrayList<>();
       over=new HashSet<>();
       Map<Integer,List<Integer>> map=new HashMap<>();
       //adjacency list construction
       for(int[] x:prerequisites){
            int curr=x[0];
            int pre=x[1];
            if(!map.containsKey(curr))
                map.put(curr,new ArrayList<>());
            List<Integer> temp=map.get(curr);
            temp.add(pre);
            map.put(curr,temp);
       }
       //boolean[] visited=new boolean[numCourses];
       for(int[] x: prerequisites){
            int curr=x[0];
            if(!over.contains(curr)){
                if(!map.containsKey(curr)){
                    res.add(curr);
                    over.add(curr);
                }
                else{
                    // it has prerequisites
                    if(!dfs(map,new boolean[numCourses],curr))
                        return new int[0];
                }
               
            }
       }
       for(int i=0;i<numCourses;i++){
        if(!over.contains(i))
            res.add(i);
       }
       return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(Map<Integer,List<Integer>> map, boolean[] visited,int curr){
        if(visited[curr])
            return false;
        if(over.contains(curr))
            return true;
        if(!map.containsKey(curr)){
            res.add(curr);
            over.add(curr);
            return true;
        }
        visited[curr]=true;
        for(int x:map.get(curr)){
            if(!dfs(map,visited,x))
                return false;
        }
        visited[curr]=false;
        res.add(curr);
        over.add(curr);
        return true;
    }
}
