class Solution {
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int islandPerimeter(int[][] grid) {
        int peri=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    peri=dfs(i,j,grid,new boolean[rows][cols]);
                    break;
                }
            }
        }
        return peri;
    }

    public int dfs(int r,int c,int[][] grid,boolean[][] visit){
        int rows=grid.length;
        int cols=grid[0].length;
        visit[r][c]=true;
        int res=0;
        for(int[] dir: directions){
            int dr=r+dir[0];
            int dc=c+dir[1];
            if(Math.min(dr,dc)<0 || dr==rows || dc==cols || grid[dr][dc]==0){
                res++;
                continue;
            }
            if(!visit[dr][dc])
                res+=dfs(dr,dc,grid,visit);
        }
        //visit[r][c]=false;
        return res;
    }
}