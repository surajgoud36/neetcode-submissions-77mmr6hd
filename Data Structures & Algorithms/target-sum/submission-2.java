class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      //  int[][] dp = new int[nums.length][target+1];
        Map<List<Integer>,Integer> dp = new HashMap<>();
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        return dfs(0,dp,nums,0,target);
    }
     public int dfs(int index, Map<List<Integer>,Integer> dp,int[] nums,int sum,int target){
        if(index>=nums.length && sum==target)
            return 1;
        if(index>=nums.length)
            return 0;
        List<Integer> curr = new ArrayList<>(Arrays.asList(index,sum));
        if(dp.containsKey(curr))
            return dp.get(curr);
        
        dp.put(curr,dfs(index+1,dp,nums,sum+nums[index],target)+dfs(index+1,dp,nums,sum-nums[index],target));
        // 2choices
        
        //dp[index][sum]=dfs(index+1,dp,nums,sum+nums[index],target)+dfs(index+1,dp,nums,sum-nums[index],target);
        return dp.get(curr);
        //return dp[index][sum];
    }
}
