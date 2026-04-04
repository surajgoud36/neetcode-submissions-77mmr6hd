class Solution {
    public int numDistinct(String s, String t) {
        int l1=s.length();
        int l2=t.length();
        int[][] dp = new int[l1][l2];
        for(int i=0;i<l1;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(0,0,s,t,dp);
    }
    public int dfs(int i1,int i2,String s, String t,int[][] dp){
        if(i2==t.length())
            return 1;
        if(i1==s.length())
            return 0;
        if(dp[i1][i2]!=-1)
            return dp[i1][i2];
        if(s.charAt(i1)!=t.charAt(i2))
            dp[i1][i2]=dfs(i1+1,i2,s,t,dp);
        else{
            dp[i1][i2]=dfs(i1+1,i2+1,s,t,dp)+dfs(i1+1,i2,s,t,dp);
        }

        return dp[i1][i2];
    }
}
