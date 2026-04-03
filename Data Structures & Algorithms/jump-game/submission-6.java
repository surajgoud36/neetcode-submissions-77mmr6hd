class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1)
            return true;
        boolean[] dp=new boolean[nums.length];
        int len=nums.length;
        dp[len-1]=true;
        for(int i=len-2;i>=0;i--){
            if(i+nums[i]>=len-1){
                dp[i]=true;
                continue;
            }
            for(int j=1;j<=nums[i];j++){
                if(dp[i+j]==true){
                    dp[i]=true;
                    break;
                }
            }

        }
        return dp[0];
    }
}
