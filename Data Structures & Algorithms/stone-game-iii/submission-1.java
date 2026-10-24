class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        Integer[] dp = new Integer[len];

        int score = dfs(0,stoneValue,dp);
        if(score == 0)
            return "Tie";
        else if(score>0)
            return "Alice";
        return "Bob";
    }
    public int dfs(int i,int[] arr,Integer[] dp){
        if(i>=arr.length)
            return 0;
        if(dp[i]!=null)
            return dp[i];
        int score =0;
        dp[i]=Integer.MIN_VALUE;
        for(int j=i;j<Math.min(i+3,arr.length);j++){
            score+=arr[j];
            dp[i]=Math.max(score - dfs(j+1,arr,dp),dp[i]);
        }
        return dp[i];
    }
}