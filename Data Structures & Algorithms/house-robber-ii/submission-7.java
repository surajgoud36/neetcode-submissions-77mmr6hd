class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[2];
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length-1;i++){
            int res=Math.max(nums[i]+dp[0],dp[1]);
            dp[0]=dp[1];
            dp[1]=res;
        }
        int res1=dp[1];
        dp[0]=nums[1];
        dp[1]=Math.max(dp[0],nums[2]);
        for(int i=3;i<nums.length;i++){
            int res=Math.max(nums[i]+dp[0],dp[1]);
            dp[0]=dp[1];
            dp[1]=res;
        }
        return Math.max(res1,dp[1]);
    }
}
