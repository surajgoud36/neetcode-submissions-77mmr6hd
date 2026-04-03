class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh=0;
        int time=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(fresh>0 && !queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                int[] curr=queue.poll();
                int r=curr[0];
                int c=curr[1];

                for(int[] dir:directions){
                    int row=r+dir[0];
                    int col=c+dir[1];
                    if(Math.min(row,col)<0 || row==grid.length || col==grid[0].length || grid[row][col]==0 || grid[row][col]==2)
                        continue;
                    grid[row][col]=2;
                    queue.add(new int[]{row,col});
                    fresh--;
                }
            }
            time++;
        }
        //System.out.println("fresh= "+fresh);
        return fresh>0? -1: time;
    }
}
