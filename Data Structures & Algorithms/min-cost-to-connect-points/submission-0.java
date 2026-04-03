record Pair(int x,int y){}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        // adj list for each node
        Set<Integer> visited=new HashSet<>();
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((n1,n2)->n1[1]-n2[1]);
        visited.add(0);
        for(int i=1;i<points.length;i++){
            int distance=distance(points[0][0],points[0][1],points[i][0],points[i][1]);
            minHeap.add(new int[]{i,distance});
        }
        int cost=0;
        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int node=curr[0],dis=curr[1];
            if(visited.contains(node))
                continue;
            cost+=dis;
            visited.add(node);
            for(int i=0;i<points.length;i++){
                if(!visited.contains(i)){
                    int distance=distance(points[node][0],points[node][1],points[i][0],points[i][1]);
                    minHeap.add(new int[]{i,distance});
                }
            }
        }
        return cost;
    }
    public int distance(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
