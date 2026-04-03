class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int res=dfs(0,dp,stoneValue);
        if(res==0)
            return "Tie";
        if(res>0)
            return "Alice";
        return "Bob";
    }
    int dfs(int index,int[] dp,int[] stoneValue){
        if(index>=stoneValue.length)
            return 0;
        if(dp[index]!=Integer.MIN_VALUE)
            return dp[index];
        int currSum=0;
        for(int i=index;i<Math.min(index+3,stoneValue.length);i++){
            currSum+=stoneValue[i];
            dp[index]=Math.max(currSum-dfs(i+1,dp,stoneValue),dp[index]);

        }
        return dp[index];
    }
}