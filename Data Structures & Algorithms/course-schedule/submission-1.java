class Solution {
    boolean[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // when you are trying to visit a node that has already been visited
        // then the algorithm should fail
        if(prerequisites.length==0)
            return true;
        Map<Integer,ArrayList<Integer>> adj=new HashMap<>();
        for(int[] x: prerequisites){
            if(!adj.containsKey(x[0])){
                adj.put(x[0],new ArrayList<>());
            }
            ArrayList<Integer> temp=adj.get(x[0]);
            temp.add(x[1]);
            adj.put(x[0],temp);
        }

        visited=new boolean[numCourses];
        for(int i=0;i<prerequisites.length;i++){
           int[] x=prerequisites[i];
           if(!visited[x[0]]){
                if(!dfs(adj,x[0]))
                    return false;
           }
        }
        return true;
        
    }

    public boolean dfs(Map<Integer,ArrayList<Integer>> adj,int start){
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        queue.add(start);
        visited[start]=true;
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                int x=queue.poll();
                System.out.println("Check= "+x);
                //visited[start]=true;
            if(!adj.containsKey(x))
                continue;
            for(int k:adj.get(x)){
                if(visited[k] && !queue.contains(k)){
                    System.out.println(k+" x= "+x);
                    return false;
                }
                    
                if(queue.contains(k))
                    continue;
                queue.add(k);
                visited[k]=true;
            }
            }
            
        }
        visited=new boolean[visited.length];
        return true;
    }
}
