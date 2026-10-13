class Solution {
    record Pair(int i,int sum){}
    public int findTargetSumWays(int[] nums, int target) {
       // Integer[][] dp = new Integer[nums.length][target+1];
        Map<Pair,Integer> dp = new HashMap<>();
        return dfs(nums,target,0,0,dp);
    }
    public int dfs(int[] nums,int target,int sum,int index, Map<Pair,Integer> dp){
        if(index>=nums.length && sum==target)
            return 1;
        if(index>=nums.length)
            return 0;
        // if(dp[index][sum]!=null)
        //     return dp[index][sum];
        Pair nP = new Pair(index,sum);
        if(dp.containsKey(nP))
            return dp.get(nP);
        
        int res = dfs(nums,target,sum+nums[index],index+1,dp) + dfs(nums,target,sum-nums[index],index+1,dp);
          dp.put(nP,res);
    return res;
    }
  
}
