class Solution {
    boolean[][] visited;
    int fresh,rotten,time;
    ArrayDeque<int[]> dq;
    public int orangesRotting(int[][] grid) {
        dq=new ArrayDeque<>();
        fresh=0; rotten=0;
        time=0;
        int rows=grid.length,cols=grid[0].length;
        visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1)
                    fresh++;
                if(grid[i][j]==2){
                    dq.add(new int[]{i,j});
                    visited[i][j]=true;
                    rotten++;
                }
                    
            }
        }
        if(fresh==0)
            return 0;
        // for(int i=0;i<rows;i++){
        //     for(int j=0;j<cols;j++){
        //         if(grid[i][j]==2 && !visited[i][j]){
        //             explore(i,j,grid);
        //         }
        //     }
        // }
        explore(grid);
        if(fresh!=0)
            return -1;
        return time;
    }

    public void explore(int[][] grid){
        int rows=grid.length;
        int cols=grid[0].length;
        //visited[r][c]=true;
       
        //dq.add(new int[]{r,c});
        boolean check=false;
        while(!dq.isEmpty()){
            check=false;
            int len=dq.size();
            for(int i=0;i<len;i++){
                int cor[]=dq.poll();
                int row=cor[0];
                int col=cor[1];
                if(grid[row][col]==1){
                    grid[row][col]=2;
                    fresh--;
                }
                int[][] neighbors={{1,0},{-1,0},{0,1},{0,-1}};
                 
                for(int[] z:neighbors){
                    int nr=row+z[0];
                    int nc=col+z[1];
                    if(nr<0||nr>=rows||nc<0||nc>=cols||grid[nr][nc]==0||visited[nr][nc])
                        continue;
                    dq.add(new int[]{nr,nc});
                    if(grid[nr][nc]==1)
                        check=true;
                    visited[nr][nc]=true;
                }
            }
            if(check)
                time++;
            
        }
    }
}
