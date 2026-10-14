class Solution {
    int max;
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        max=0;
        Integer[][] dp = new Integer[len][len];
        for(int i=0;i<s.length();i++){
            dfs(s.toCharArray(),dp,i,i);
            dfs(s.toCharArray(),dp,i,i+1);
        }
        return max;
    }
    public int dfs(char[] arr,Integer[][] dp,int i,int j){
        if(i<0 || j>=arr.length)
            return 0;
        if(dp[i][j]!=null)
            return dp[i][j];
        dp[i][j]=0;
        if(arr[i]==arr[j]){
            if(i == j){
                dp[i][j] = 1 + dfs(arr,dp,i-1,j+1);
            }
            else
                dp[i][j] = 2 + dfs(arr,dp,i-1,j+1);
        }else{
            dp[i][j] = Math.max(dp[i][j],dfs(arr,dp,i-1,j));
            dp[i][j] = Math.max(dp[i][j],dfs(arr,dp,i,j+1));
        }
        max=Math.max(max,dp[i][j]);
        return dp[i][j];
    }
}