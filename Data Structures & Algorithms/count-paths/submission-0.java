class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev=new int[n];
        Arrays.fill(prev,0);
        for(int i=0;i<m;i++){
            int[] curr=new int[n];
            curr[n-1]=1;
            for(int j=n-2;j>=0;j--)
                curr[j]=curr[j+1]+prev[j];
            prev=curr;
        }
        return prev[0];

    }
}
