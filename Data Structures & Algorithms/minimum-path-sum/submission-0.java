class Solution {
    public int minPathSum(int[][] grid) {
        int rows=grid.length, cols=grid[0].length;
        int[][] dp= new int[rows][cols];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return dfs(dp,0,0,grid,rows,cols);
    }
    public int dfs(int[][] dp,int i,int j,int[][] grid,int rows,int cols){
        if(i>=dp.length || j>=dp[0].length)
            return Integer.MAX_VALUE;
        if(i==rows-1 && j==cols-1)
            return grid[i][j];
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int sum= Integer.MAX_VALUE;
        int next1=dfs(dp,i,j+1,grid,rows,cols);
        int next2=dfs(dp,i+1,j,grid,rows,cols);
        boolean haveSomething=false;
        if(next1!=Integer.MAX_VALUE){
            sum=next1+grid[i][j];
            haveSomething=true;
        }
        if(next2!=Integer.MAX_VALUE)
        {
            sum=Math.min(sum,grid[i][j]+next2);
            haveSomething=true;
        }
        if(haveSomething){
            dp[i][j]=sum;
            return dp[i][j];
        }
        return Integer.MAX_VALUE;
    }
}