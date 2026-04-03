class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visit= new boolean[rows][cols];
        Queue<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{0,0});
        visit[0][0]=true;
        int len=1;
        while(!queue.isEmpty()){
            int queLen=queue.size();
            for(int i=0;i<queLen;i++){
                int[] cor=queue.poll();
                int r=cor[0],c=cor[1];
                if(r==rows-1 && c==cols-1)
                    return len;
                int[][] directions={{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1},{0,1},{0,-1}};
                for(int[] dir:directions){
                    int dr=dir[0],dc=dir[1];
                    // check for invalid
                    if(!check(r+dr,c+dc,visit,rows,cols,grid))
                        continue;
                    queue.add(new int[]{r+dr,c+dc});
                    visit[r+dr][c+dc]=true;
                }
            }
            len++;
        }
        return -1;
    }

    public boolean check(int r,int c,boolean[][] visit,int rows,int cols,int[][] grid){
        if(Math.min(r,c)<0 || r==rows|| c==cols || visit[r][c] || grid[r][c]==1)
            return false;
        return true;
    }
}