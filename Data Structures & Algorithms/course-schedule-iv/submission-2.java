class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // adj list setup
        Map<Integer,ArrayList<Integer>> adj=new HashMap<>();
        Map<Integer,Set<Integer>> prereq=new HashMap<>();
        for(int i=0;i<numCourses;i++)
            adj.put(i,new ArrayList<>());
        for(int[] pair:prerequisites){
            int dst=pair[0];
            int src=pair[1];
            adj.get(src).add(dst);
        }
        List<Integer> res=new ArrayList<>();
        Set<Integer> visit=new HashSet<>();
        // for(int i=0;i<numCourses;i++)
        //     dfs(adj,res,visit,i);
        // we have the order in res
        for(int i=0;i<numCourses;i++){
            dfs(prereq,adj,i);
        }
        List<Boolean> blist=new ArrayList<>();
        for(int[] x:queries){
            int i1=x[0];
            int i2=x[1];
            blist.add(prereq.get(i2).contains(i1));
            // if(i2<i1)
            //     blist.add(true);
            // else
            //     blist.add(false);
        }
        return blist;
    }
    // public void dfs( Map<Integer,ArrayList<Integer>> adj,List<Integer> res,Set<Integer> visit,Integer curr){
    //     if(visit.contains(curr))
    //         return;
    //     visit.add(curr);
    //     for(Integer x:adj.get(curr)){
    //         dfs(adj,res,visit,curr);
    //     }
    //     res.add(curr);
    // }
    public Set<Integer> dfs(Map<Integer,Set<Integer>> prereq,Map<Integer,ArrayList<Integer>> adj,int curr){
        if(prereq.containsKey(curr))
            return prereq.get(curr);
        Set<Integer> prereqs=new HashSet<>();
        for(Integer x:adj.get(curr)){
            prereqs.addAll(dfs(prereq,adj,x));
        }
        prereqs.add(curr);
        prereq.put(curr,prereqs);
       
        return prereqs;
    }
}