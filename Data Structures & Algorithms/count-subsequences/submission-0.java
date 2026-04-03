class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()][t.length()];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        return dfs(dp,s,0,t,0);
    }
    public int dfs(int[][] dp,String s,int i1,String t,int i2){

        //base case
        if(i2==t.length())
            return 1;
        if(i1==s.length())
            return 0;
        if(dp[i1][i2]!=-1)
            return dp[i1][i2];
        // if there is a match
        if(s.charAt(i1)==t.charAt(i2))
            dp[i1][i2]=dfs(dp,s,i1+1,t,i2)+dfs(dp,s,i1+1,t,i2+1);
        else
            dp[i1][i2]=dfs(dp,s,i1+1,t,i2);
        return dp[i1][i2];
    }
}
