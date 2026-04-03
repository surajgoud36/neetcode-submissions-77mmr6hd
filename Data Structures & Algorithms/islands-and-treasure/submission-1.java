class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==Integer.MAX_VALUE)
                    grid[i][j]=bfs(grid,i,j);
            }
        }
    }
    public int bfs(int[][] grid,int r,int c){
        int rows=grid.length,cols=grid[0].length;
        boolean visited[][]=new boolean[rows][cols];
        ArrayDeque<int[]> q=new ArrayDeque<>();
        visited[r][c]=true;
        q.add(new int[]{r,c});
        int dis=0;

        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] cor=q.poll();
                int row=cor[0],col=cor[1];
                if(grid[row][col]==0)
                    return dis;
                for(int[] dir:directions){
                    int nr = row + dir[0], nc = col + dir[1];
                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && !visited[nr][nc] && grid[nr][nc]!=-1){
                        visited[nr][nc]=true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            
            dis++;
        }
        return Integer.MAX_VALUE;
    }
}
