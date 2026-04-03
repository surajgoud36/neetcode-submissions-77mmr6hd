class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visit=new boolean[rows][cols];
        ArrayDeque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{0,0});
        visit[0][0]=true;
        int length=0;
        int len=dq.size();
        while(!dq.isEmpty()){
            len=dq.size();
            length++;
            for(int i=0;i<len;i++){
                int cor[]=dq.poll();
                int r=cor[0];
                int c=cor[1];
                if(r==rows-1 && c==cols-1)
                    return length;
                // we explore its childeren by adding it to queue, by exploring all 6 directions
                // add only valid childern and we have to visit any valid only once 
                // so when you add child to the queue, mark it as visited
                int[][] set={{1,0},{-1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,-1},{1,1}};
                for(int[] x:set){
                    int ri=x[0],ci=x[1];
                    if(valid(visit,ri+r,ci+c,rows,cols,grid)){
                        dq.add(new int[]{ri+r,ci+c});
                        visit[ri+r][ci+c]=true;
                    }

                }

            }
        }
        return -1;
    }
    public boolean valid(boolean[][] visit,int r,int c,int rows,int cols,int[][] grid){
        if(r>=rows||r<0||c>=cols||c<0||grid[r][c]==1||visit[r][c])
            return false;
        return true;
    }
}