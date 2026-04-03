class Solution {
    int res;
    public int numIslands(char[][] grid) {
        res=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int r,int c){
        int rows=grid.length;
        int cols=grid[0].length;
        if(Math.min(r,c)<0 || r==rows || c==cols || grid[r][c]=='0')
            return;
        grid[r][c]='0';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}
