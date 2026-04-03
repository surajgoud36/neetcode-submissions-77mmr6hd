class NumMatrix {
    int[][] rows;
    //int[][] cols;
    public NumMatrix(int[][] matrix) {
        rows=new int[matrix.length][matrix[0].length];
       // cols=new int[matrix.length][matrix[0].length];
        // lets go over the rows
        for(int i=0;i<matrix.length;i++){
            int sum=0;
            for(int j=0;j<matrix[0].length;j++){
                sum+=matrix[i][j];
                rows[i][j]=sum;
            }
        }
        // // lets go over the columns
        // for(int i=0;i<matrix[0].length;i++){
        //     int sum=0;
        //     for(int j=0;j<matrix.length;j++){
        //         sum+=matrix[j][i];
        //         rows[j][i]=sum;
        //     }
        // }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        //lets do the rows
        if(col1==0){
            for(int i=row1;i<=row2;i++){
                sum+=rows[i][col2];
            }
           // sum+=rows[row1][col2]+rows[row2][col2];
        }
        else{
            for(int i=row1;i<=row2;i++){
                sum+=rows[i][col2]-rows[i][col1-1];
            }
            //sum+=rows[row1][col2]-rows[row1][col1-1]+rows[row2][col2]-rows[row2][col1-1];
        }
       // row1++;
        //row2--;
        //System.out.println(sum);
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */