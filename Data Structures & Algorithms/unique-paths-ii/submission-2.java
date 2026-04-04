class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows=obstacleGrid.length;
        int cols=obstacleGrid[0].length;
        int[] nextRow=new int[cols+1];
        int[] currRow= new int[cols+1];
        if(obstacleGrid[rows-1][cols-1]==1)
            return 0;
        currRow[cols-1]=1;
       // System.out.println()
        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=0;j--){
                if(obstacleGrid[i][j]!=1)
                    currRow[j]+=currRow[j+1]+nextRow[j];
            }
            nextRow=Arrays.copyOf(currRow,currRow.length);
            //System.out.println(Arrays.toString(nextRow));
            Arrays.fill(currRow,0);
        }
        return nextRow[0];
    }
}