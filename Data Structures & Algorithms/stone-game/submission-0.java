class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int res=dfs(piles,dp,0,piles.length-1);
        System.out.println("res= "+res);
        return res>0;
    }
    public int dfs(int[] piles,int[][] dp,int i,int j){
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int score1=piles[i]-dfs(piles,dp,i+1,j);
        int score2=piles[j]-dfs(piles,dp,i,j-1);
        dp[i][j]=Math.max(score1,score2);
        return dp[i][j];
    }
}