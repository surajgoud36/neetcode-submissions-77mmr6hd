class Solution {
    record Pair(int x,int y){}
    public int numIslands(char[][] grid) {
        Set<Pair> set = new HashSet<>();
        int rows=grid.length,cols=grid[0].length;
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]!='0'){
                    count++;
                    //call bfs
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,int i,int j){
        grid[i][j]='0';
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            i = curr[0];
            j=curr[1];
            for(int[] dir:directions){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(Math.min(nr,nc)<0 || nr==grid.length || nc == grid[0].length || grid[nr][nc]=='0')
                continue;
            grid[nr][nc] = '0';
            q.add(new int[]{nr,nc});
         }
        }
        

    }
}
