class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[][] tr = new int[cols][rows];
        int col=0;
        for(int i=0;i<rows;i++){
            int row=0;
            for(int j=0;j<cols;j++){
               
                tr[row++][col]=matrix[i][j];
            }
            col++;
        }
        return tr;
    }
}