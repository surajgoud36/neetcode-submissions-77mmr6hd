class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // topological sort using the kahn's alg
        int[] ind = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int[] pre: prerequisites){
            int src=pre[1];
            int dst = pre[0];
            adj.get(src).add(dst);
            ind[dst]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(ind[i] == 0)
                q.add(i);
        }
        int processed =0;
        int[] op = new int[numCourses];
        int j=0;
        while(!q.isEmpty()){
            int cur = q.poll();
            op[j++] = cur;
            for(int nei:adj.get(cur)){
                ind[nei]--;
                if(ind[nei] == 0)
                    q.add(nei);
            }
            processed++;
        }
        if(processed<numCourses)
            return new int[0];
        return op;

    }
}
