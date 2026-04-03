class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows=obstacleGrid.length;
        int cols=obstacleGrid[0].length;
        if(obstacleGrid[rows-1][cols-1]==1)
            return 0;
            //obstacleGrid[rows-1][cols-1]=1;
        //System.out.println(obstacleGrid[rows-1][cols-1]);
        int prev[]=new int[cols];
        Arrays.fill(prev,0);
        prev[cols-1]=1;
        for(int i=rows-1;i>=0;i--){
            int[] curr=new int[cols];
            curr[cols-1]= obstacleGrid[i][cols-1]==0?prev[cols-1]:0;
            for(int j=cols-2;j>=0;j--){
                if(obstacleGrid[i][j]==1)
                    curr[j]=0;
                else
                    curr[j]=curr[j+1]+prev[j];
            }
            prev=curr;
        }
        return prev[0];
    }
}