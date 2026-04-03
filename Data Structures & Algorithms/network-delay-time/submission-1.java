class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create a adjacency list
        Map<Integer,List<int[]>> map = new HashMap<>();
        Map<Integer,Integer> visited = new HashMap<>();
        for(int[] edge:times){
            int source=edge[0];
            int dst=edge[1];
            int wt=edge[2];
            map.computeIfAbsent(source,l->new ArrayList<>()).add(new int[]{dst,wt});
        }
        // min heap to process the edges
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt((int[] a)-> a[1]));
        minHeap.add(new int[]{k,0});
        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            if(visited.containsKey(curr[0]))
                continue;
            visited.put(curr[0],curr[1]);
            max=Math.max(max,curr[1]);
            // try adding its neighbors
            int currWeight=curr[1];
            if(map.containsKey(curr[0])){
                 for(int[] edge: map.get(curr[0])){
                minHeap.add(new int[]{edge[0],edge[1]+currWeight});
            }
            }
           

        }
        if(visited.size()<n)
            return -1;
        return max;

    }
}
