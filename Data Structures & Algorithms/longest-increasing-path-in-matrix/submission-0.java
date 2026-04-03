public record Pair<K,V>(K key, V value){}
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        Pair[][] arr=new Pair[rows][cols];
        Integer[][] lens=new Integer[rows][cols];
        int maxLen=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                maxLen=Math.max(dfs(i,j,matrix,lens,rows,cols),maxLen);
            }
        }
        return maxLen;
    }

    public int dfs(int i,int j,int[][] matrix,Integer[][] arr,int rows,int cols){
        
        if(arr[i][j]!=null)
            return arr[i][j];
        // not seen before
        arr[i][j]=1; 
        int max=0;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] x: directions){
            int nrow=i+x[0];
            int ncol=j+x[1];
            if(valid(nrow,ncol,rows,cols) && matrix[nrow][ncol]>matrix[i][j])
                max=Math.max(max,dfs(nrow,ncol,matrix,arr,rows,cols));
           
        }
        arr[i][j]+=max;
        return arr[i][j];
    }
    public boolean valid(int i,int j,int rows,int cols){
        if(i>=rows || i<0 || j>=cols || j<0)
            return false;
        return true;
    }
}
