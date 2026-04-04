class Solution {
    public int minCostConnectPoints(int[][] points) {
        int cost=0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt((int[] p)->p[1]));
        for(int i=1;i<points.length;i++){
            int distance = manhattanDistance(points[0],points[i]);
            minHeap.add(new int[]{i,distance});
        }
        visited.add(0);
        while(!minHeap.isEmpty()){
            if(visited.size()==points.length)
                break;
            int[] curr=minHeap.poll();
           // List<Integer> currPoint = new ArrayList<>(Arrays.asList(curr[0],curr[1]));

            if(visited.contains(curr[0]))
                continue;
            visited.add(curr[0]);
            cost+=curr[1];
            for(int i=0;i<points.length;i++){
                if(!visited.contains(i)){
                    int dis = manhattanDistance(points[curr[0]],points[i]);
                    minHeap.add(new int[]{i,dis});
                }
            }
            
        }
        return cost;

    }
    public int manhattanDistance(int[] p1,int[] p2){
        return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
    }
}
