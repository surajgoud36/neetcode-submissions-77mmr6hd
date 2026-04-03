class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        //last row
        for(int i=0;i<=t.length();i++)
            dp[s.length()][i]=0;
        // last col
        for(int i=0;i<=s.length();i++)
            dp[i][t.length()]=1;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=t.length()-1;j>=0;j--){
                if(s.charAt(i)==t.charAt(j))
                    dp[i][j]=dp[i+1][j]+dp[i+1][j+1];
                else
                    dp[i][j]=dp[i+1][j];
            }
        }
        return dp[0][0];
        // for(int[] arr:dp)
        //     Arrays.fill(arr,-1);
        // return dfs(dp,s,0,t,0);
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
