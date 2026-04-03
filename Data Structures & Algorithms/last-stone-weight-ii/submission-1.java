class Solution {
    public int lastStoneWeightII(int[] stones) {
        // find the half the sum of the stones
        int stoneSum=0;
        for(int stone:stones)
            stoneSum+=stone;
        // half the sum, ceiling if it is odd
        int target=(stoneSum+1)/2; 
        int[][] dp=new int[stones.length][target+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return dfs(0,0,stones,dp,stoneSum,target);
    }
    public int dfs(int i,int total,int[] stones,int[][] dp,int stoneSum,int target){
        // base case
        if(i>=stones.length || total>target){
            // we either went out of bounds or just went over half the total sum ,
            // now we just have to return the difference of the two piles we have 
            return Math.abs(total-(stoneSum-total));
        }
        if(dp[i][total]!=-1)
            return dp[i][total];
        dp[i][total]=Math.min(dfs(i+1,total,stones,dp,stoneSum,target),dfs(i+1,total+stones[i],stones,dp,stoneSum,target));
        return dp[i][total];
    }
}