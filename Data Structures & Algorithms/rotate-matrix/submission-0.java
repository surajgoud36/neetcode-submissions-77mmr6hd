class Solution {
    public void rotate(int[][] matrix) {
        // vertically reverse the matrix

        int i=0,j=matrix.length-1;
        while(i<=j){
            // we swap the rows
            int[] temp=matrix[i];
            matrix[i]=matrix[j];
            matrix[j]=temp;
            i++;
            j--;
        }

        // now we transpose the matrix, where first row becomes the first col
        // we move diagonally down to the right, there by reducing the remaining problem 
        // space of the matrix

        int ci=0,cj=0;
        while(ci<matrix.length-1){
            i=ci+1;j=cj+1;
            while(i<matrix.length){
                int temp=matrix[i][cj];
                matrix[i][cj]=matrix[ci][j];
                matrix[ci][j]=temp;
                i++;
                j++;
            }
            ci++;
            cj++;
        }
    }
}
