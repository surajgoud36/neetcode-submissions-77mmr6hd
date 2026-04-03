class Solution {
    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp= new int[len1+1][len2+1];
        // last row
        for(int i=len2;i>=0;i--){
            dp[len1][i]=len2-i;
        }
        // last col
        for(int i=len1;i>=0;i--){
            dp[i][len2]=len1-i;
        }

        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                if(word1.charAt(i)==word2.charAt(j))
                    dp[i][j]=dp[i+1][j+1];
                else{
                    dp[i][j]=1+Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
