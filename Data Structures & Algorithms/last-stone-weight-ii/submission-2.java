class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total=0;
        for(int i=0;i<stones.length;i++){
            total+=stones[i];
        }
        int target = total/2;
        int dp[][] = new int[stones.length][target+1];
        for(int i=0;i<stones.length;i++){
            Arrays.fill(dp[i],-1);
        }
        // you can use a map or a 2-d array
        return dfs(0,dp,0,target,total,stones);
    }
    public int dfs(int i, int dp[][],int sum,int target,int total,int[] stones){
        if(sum>=target || i>=stones.length){
            return Math.abs(sum-(total-sum));
        }
        if(dp[i][sum]!=-1)
            return dp[i][sum];
        dp[i][sum]=Math.min(dfs(i+1,dp,sum,target,total,stones),dfs(i+1,dp,sum+stones[i],target,total,stones));
        return dp[i][sum];
    }
}