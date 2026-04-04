class Solution {
    public int uniquePaths(int m, int n) {
        // lets do the btm up approach
        int[] nextRow=new int[n+1];
        int [] currRow =  new int[n+1];
        currRow[n-1]=1;
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                currRow[j]=currRow[j]+nextRow[j]+currRow[j+1];
            }
            nextRow=Arrays.copyOf(currRow,currRow.length);
            Arrays.fill(currRow,0);
        }
        return nextRow[0];
    }
}
