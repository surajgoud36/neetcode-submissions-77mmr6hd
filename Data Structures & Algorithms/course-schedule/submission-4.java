class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build an adjacency list
        Map<Integer,List<Integer>> adjList=new HashMap<>();
        for(int[] prereq:prerequisites){
            int src=prereq[0];
            int dst=prereq[1];
            adjList.computeIfAbsent(src,k->new ArrayList<>()).add(dst);
            if(!adjList.containsKey(dst))
                adjList.put(dst,new ArrayList<>());

        }
        Set<Integer> waiting=new HashSet<>();
        Set<Integer> done=new HashSet<>();
        for(int i=0;i<numCourses;i++){
            if(!isPossible(i,adjList,waiting,done))
                return false;
        }
        return true;
    }

    public boolean isPossible(int course, Map<Integer,List<Integer>> adjList, Set<Integer> waiting, Set<Integer> done){
        if(waiting.contains(course))
            return false;
        if(done.contains(course))
            return true;
         waiting.add(course);
         if(adjList.containsKey(course)){
            for(int req: adjList.get(course)){
            if(!isPossible(req,adjList,waiting,done))
                return false;
         }
         }
         

         waiting.remove(course);
         done.add(course);
         return true;
    }
}
