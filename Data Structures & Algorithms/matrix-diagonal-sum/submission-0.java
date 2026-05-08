class Solution {
    public int diagonalSum(int[][] mat) {
        int diag1=0;
        int len=mat.length;
        for(int i=0;i<len;i++){
            diag1+=mat[i][i];
        }
        int j=len-1;
        for(int i=0;i<len;i++){
            if(i!=j)
                diag1+=mat[i][j];
            j--;
        }
        return diag1;
    }
}