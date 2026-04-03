record Pair(int node,double prob){}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int dst=edges[i][1];
            //int wt=succProb[i];
            map.computeIfAbsent(src,k->new ArrayList<>()).add(new int[]{dst,i});
            map.computeIfAbsent(dst,k->new ArrayList<>()).add(new int[]{src,i});
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparingDouble((Pair x)->x.prob()).reversed());
        maxHeap.add(new Pair(start_node,1.0));
        Set<Integer> visited = new HashSet<>();
        visited.add(start_node);
        double max=0.0;
        while(!maxHeap.isEmpty()){
            Pair curr = maxHeap.poll();
            int node=curr.node();
            double prob=curr.prob();
            if(node==end_node){
                max=Math.max(max,prob);
                continue;
            }
            visited.add(node);
            if(map.containsKey(node)){
                for(int[] neigh:map.get(node)){
                    int nextNode=neigh[0];
                    double nextProb=succProb[neigh[1]];
                    if(!visited.contains(nextNode)){
                        maxHeap.add(new Pair(nextNode,prob*nextProb));
                    }
                }
            }
           
        }
        return Math.max(0.0,max);
    }
}