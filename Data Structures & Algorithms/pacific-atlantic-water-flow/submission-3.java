class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    int rows,cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        rows=heights.length;
        cols=heights[0].length;

        boolean[][] atlantic= new boolean[rows][cols];
        boolean[][] pacific = new boolean[rows][cols];

        for(int i=0;i<cols;i++){
            pacific[0][i]=true;
            atlantic[rows-1][i]=true;
        }
        for(int i=0;i<rows;i++){
            pacific[i][0]=true;
            atlantic[i][cols-1]=true;
        }

        for(int i=0;i<cols;i++){
            //pacific[0][i]=true;
            dfs(0,i,pacific,heights);
            dfs(rows-1,i,atlantic,heights);
            //atlantic[rows-1][i]=true;
        }
        for(int i=0;i<rows;i++){
            // pacific[i][0]=true;
            // atlantic[i][cols-1]=true;
            dfs(i,0,pacific,heights);
            dfs(i,cols-1,atlantic,heights);
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(atlantic[i][j] && pacific[i][j])
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return res;
    }

    public void dfs(int r,int c,boolean[][] ocean,int[][] heights){
        for(int[] dir:directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(Math.min(nr,nc)<0 || nr==rows || nc==cols || ocean[nr][nc]|| heights[nr][nc]<heights[r][c])
                continue;
            ocean[nr][nc]=true;
            dfs(nr,nc,ocean,heights);
        }
    }
}
