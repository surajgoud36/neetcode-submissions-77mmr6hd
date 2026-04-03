class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         int res=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    res=Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;
    }

     public int dfs(int[][] grid,int r,int c){
        int rows=grid.length;
        int cols=grid[0].length;
        if(Math.min(r,c)<0 || r==rows || c==cols || grid[r][c]==0)
            return 0;
        grid[r][c]=0;
        int count=0;
        count+=dfs(grid,r+1,c);
        count+=dfs(grid,r-1,c);
        count+=dfs(grid,r,c-1);
        count+=dfs(grid,r,c+1);
        count+=1;
        return count;
    }
}
