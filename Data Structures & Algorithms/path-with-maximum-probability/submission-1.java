record Pair(int x,double p){}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        double[] visited=new double[n];
        for(int i=0;i<n;i++)
            visited[i]=-1.0;
        PriorityQueue<Pair> minHeap=new PriorityQueue<>((n1,n2)->Double.compare(n2.p(),n1.p()));
        Map<Integer,ArrayList<int[]>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<int[]>());
        }
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0],dst=edges[i][1];
            adj.get(src).add(new int[]{dst,i});
            adj.get(dst).add(new int[]{src,i});
        }
        minHeap.add(new Pair(start_node,1.0));
        while(!minHeap.isEmpty()){
            Pair curr=minHeap.poll();
            int n1=curr.x();
            double p1=curr.p();
            if(visited[n1]!=-1.0)
                continue;
            visited[n1]=p1;
            for(int[] child:adj.get(n1)){
                int n2=child[0];
                double p2=succProb[child[1]];
                System.out.println("n2= "+n2+" p2= "+p2);
                if(visited[n2]==-1.0)
                    minHeap.add(new Pair(n2,p1*p2));
            }
        }
        System.out.println(Arrays.toString(visited));
        return visited[end_node]==-1.0?0.0:visited[end_node];
    }
}