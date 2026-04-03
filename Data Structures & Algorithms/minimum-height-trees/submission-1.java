class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length==0)
            return new ArrayList<>(Arrays.asList(0));
        Map<Integer,List<Integer>> adj = new HashMap<>();
        Map<Integer,Integer> count = new HashMap<>();

        for(int[] edge:edges){
            adj.computeIfAbsent(edge[0],k->new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1],k->new ArrayList<>()).add(edge[0]);
            count.put(edge[0],count.getOrDefault(edge[0],0)+1);
            count.put(edge[1],count.getOrDefault(edge[1],0)+1);
        }
        Queue<Integer> q=new ArrayDeque<>();
        for(int k: count.keySet()){
            if(count.get(k)==1)
                q.add(k);
        }   

        while(!q.isEmpty()){
            int len=q.size();
            if(n<=2)
                break;
            for(int i=0;i<len;i++){
                int node=q.poll();
                n--;
                for(int neigh:adj.get(node)){
                    int c=count.get(neigh);
                    c--;
                    if(c==1)
                        q.add(neigh);
                    count.put(neigh,c);
                }
            }
        }
        return new ArrayList<>(q);
    }
}