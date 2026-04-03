class Solution {
    public int swimInWater(int[][] grid) {
        Set<List<Integer>> visit = new HashSet<>();
        int max=Integer.MIN_VALUE;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt((int[] k)->k[2]));
        minHeap.add(new int[]{0,0,grid[0][0]});
        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            max=Math.max(max,curr[2]);
            if(curr[0]==grid.length-1 && curr[1]==grid.length-1)
                return max;
            for(int[] dir:directions){
                int nr=curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                if(Math.min(nr,nc)<0 || Math.max(nr,nc)>=grid.length || visit.contains(new ArrayList<>(Arrays.asList(nr,nc))))
                    continue;
                visit.add(new ArrayList<>(Arrays.asList(nr,nc)));
                minHeap.add(new int[]{nr,nc,grid[nr][nc]});
            }
        }
        return max;
    }
}
