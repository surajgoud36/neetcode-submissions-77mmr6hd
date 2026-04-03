class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache=new int[cost.length];
        Arrays.fill(cache,-1);
        return Math.min(dp(0,cost,cache),dp(1,cost,cache));
    }

    public int dp(int index,int[] cost,int[] cache){
        if(index>=cost.length)
            return 0;
        if(cache[index]!=-1)
            return cache[index];
        cache[index]=cost[index]+Math.min(dp(index+1,cost,cache),dp(index+2,cost,cache));
        return cache[index];
    }
}
