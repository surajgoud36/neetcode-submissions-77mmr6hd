class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(bfs(heights,i,j))
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return res;
    }

    public boolean bfs(int[][] heights,int r,int c){
        // check if it is the borders
         int rows=heights.length;
         int cols=heights[0].length;
        boolean pacific=false,atlantic=false;
        boolean[][] visited=new boolean[rows][cols];
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{r,c});
        visited[r][c]=true;
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] cor=q.poll();
                int row=cor[0];
                int col=cor[1];
                // check adjoining seas
                if(row==0||col==0)
                    pacific=true;
                if(row==rows-1 || col==cols-1)
                    atlantic=true;
                if(pacific&&atlantic)
                    return true;
                // check children or neighbors
                int[][] neighbors={{1,0},{0,1},{-1,0},{0,-1}};
                for(int[] x: neighbors){
                    int nr=row+x[0];
                    int nc=col+x[1];
                    if(nr<0||nr>=rows||nc<0||nc>=cols||visited[nr][nc]||heights[nr][nc]>heights[row][col])
                        continue;
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
        return false;

    }
}
