class Solution {
    public int minDistance(String word1, String word2) {
        int l1=word1.length();
        int l2=word2.length();
        int[][] dp = new int[l1][l2];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return dfs(dp,word1.toCharArray(),word2.toCharArray(),0,0);
    }
    public int dfs(int[][] dp,char[] w1,char[] w2,int i1,int i2){
        if(i2>=w2.length){
            return w1.length - i1;
        }
        if(i1>=w1.length){
            return w2.length-i2;
        }
        if(dp[i1][i2]!=-1)
            return dp[i1][i2];
       
        if(w1[i1] == w2[i2]){
            dp[i1][i2] = dfs(dp,w1,w2,i1+1,i2+1);
        }else{
            dp[i1][i2] = 1+dfs(dp,w1,w2,i1,i2+1); // insert
            dp[i1][i2] = Math.min(dp[i1][i2],dfs(dp,w1,w2,i1+1,i2)+1); // delete
            dp[i1][i2] = Math.min(dp[i1][i2],dfs(dp,w1,w2,i1+1,i2+1)+1); // replace
        }

        return dp[i1][i2];
    }
}

