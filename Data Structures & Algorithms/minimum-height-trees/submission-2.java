class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length==0)
            return new ArrayList<>(Arrays.asList(0));
        Map<Integer,List<Integer>> adj = new HashMap<>();
        Map<Integer,Integer> count = new HashMap<>();
        for(int[] edge:edges){
            adj.computeIfAbsent(edge[0],k->new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1],k->new ArrayList<>()).add(edge[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(Map.Entry<Integer,List<Integer>> entry:adj.entrySet()){
            count.put(entry.getKey(),entry.getValue().size());
            if(count.get(entry.getKey())==1)
                q.add(entry.getKey());
        }
        while(!q.isEmpty()){
            if(n<=2)
                break;
            int len=q.size();
            for(int i=0;i<len;i++){
                int curr=q.poll();
                n--;
                for(int neigh:adj.get(curr)){
                    int c=count.get(neigh);
                    c--;
                    count.put(neigh,c);
                    if(c==1)
                        q.add(neigh);
                }
            }
        }
        return new ArrayList<>(q);
    }
}