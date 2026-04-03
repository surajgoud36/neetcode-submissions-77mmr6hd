class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(
            Comparator.comparingInt((int[] p)-> p[2])
        );
        int rows = heights.length;
        int cols= heights[0].length;
        minHeap.add(new int[]{0,0,0});
        boolean visited[][]=new boolean[heights.length][heights[0].length];
        int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
        int min=Integer.MAX_VALUE;
        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int r=curr[0];
            int c=curr[1];
            int wt=curr[2];
            if(r==rows-1 && c==cols-1)
            {
                min=Math.min(min,wt);
                return min;
            }
            visited[r][c]=true;
            for(int[] dir:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(Math.min(nr,nc)<0 || nr>=rows || nc>=cols|| visited[nr][nc])
                    continue;
                int newWeight=Math.max(Math.abs(heights[r][c]-heights[nr][nc]),wt);
                minHeap.add(new int[]{nr,nc,newWeight});
            }
        }
        return min;
    }
}