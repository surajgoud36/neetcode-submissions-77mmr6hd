class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
                else if(grid[i][j]==1)
                    count++;
            }
        }
        int time =-1;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            time++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                int r=cur[0],c=cur[1];
                for(int[] dir:directions){
                    int nr = r+dir[0];
                    int nc = c+ dir[1];
                    if(Math.min(nr,nc)<0 || nr == grid.length || nc == grid[0].length || grid[nr][nc] == 2 || grid[nr][nc]==0)
                        continue;
                    grid[nr][nc] = 2;
                    count--;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        if(time ==-1)
            time=0;
        return count==0?time:-1;
    }
}
