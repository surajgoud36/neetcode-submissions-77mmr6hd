class Solution {
    int count;
    public int numIslands(char[][] grid) {
        count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
                    
            }
        }
        return count;
    }
    public void dfs(int i,int j,char[][] grid){
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        grid[i][j]='0';
        for(int[] dir:directions){
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(Math.min(nr,nc)<0 || nr==grid.length || nc==grid[0].length || grid[nr][nc]=='0')
                continue;
            dfs(nr,nc,grid);
        }
    }
}
