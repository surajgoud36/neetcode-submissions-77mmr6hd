class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        numIslands(grid);
        return max;
    }


     int count,max;
    boolean[][] visit;
    public int numIslands(int[][] grid) {
        // visit array
        max=0;
        int rows=grid.length;
        int cols=grid[0].length;
        visit=new boolean[rows][cols];
        count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(grid,false,i,j,rows,cols);
            }
        }
        return count;
    }
    public void dfs(int[][] grid,boolean prev,int r,int c,int rows,int cols){
        // base case- out of bounds, already visited
        if(r>=rows || c>=cols || c<0 || r<0 || grid[r][c]==0 ||visit[r][c])
            return;
        if(!prev){
            prev=true;
            count=0;
        }
        count++;
        max=Math.max(max,count);
        visit[r][c]=true;
        dfs(grid,prev,r+1,c,rows,cols);
        dfs(grid,prev,r-1,c,rows,cols);
        dfs(grid,prev,r,c+1,rows,cols);
        dfs(grid,prev,r,c-1,rows,cols);


    }
}
