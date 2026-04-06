record Pair(int x,int y){}
class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<Set<Pair>> parentSet = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    // we have call the dfs function
                    Set<Pair> islands = dfs(i,j,grid);
                    Set<Pair> transformed = new HashSet<>();
                    for(Pair island:islands){
                        transformed.add(new Pair(island.x()-i,island.y()-j));
                    }
                    parentSet.add(transformed);
                }
            }
        }
        return parentSet.size();
    }
    public Set<Pair> dfs(int r,int c,int[][] grid){
        grid[r][c]=0;
        Set<Pair> curr= new HashSet<>();
        curr.add(new Pair(r,c));
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(Math.min(nr,nc)<0 || nr>=grid.length || nc>=grid[0].length||grid[nr][nc]==0)
                continue;
            curr.addAll(dfs(nr,nc,grid));
        }
        return curr;
    }
}
