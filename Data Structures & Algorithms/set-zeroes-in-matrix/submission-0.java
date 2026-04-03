class Solution {
    public void setZeroes(int[][] matrix) {
        int firstRow=-1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    if(i==0)
                        firstRow=0;
                    else
                        matrix[i][0]=0;
                }
            }
        }
       // System.out.println("firstRow= "+firstRow);
      //  System.out.println(Arrays.deepToString(matrix));
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(i==0 && matrix[i][j]!=0){
                    if(firstRow==0)
                        matrix[i][j]=0;
                }
                else if(i!=0){
                    if(matrix[0][j]==0 || matrix[i][0]==0)
                        matrix[i][j]=0;
                }
            }
        }
        // check first col 
        if(matrix[0][0]==0){
            for(int i=1;i<matrix.length;i++)
                matrix[i][0]=0;
        }

        // check first row 
        if(firstRow==0){
            for(int i=0;i<matrix[0].length;i++)
                matrix[0][i]=0;
        }

    }
}
