class Solution {
    public int maxCoins(int[] nums) {
        int len=nums.length+2;
        int rnums[]=new int[len];
        rnums[0]=1;
        rnums[len-1]=1;
        for(int i=1;i<len-1;i++)
            rnums[i]=nums[i-1];
       // System.out.println(Arrays.toString(rnums));
       Integer[][] dp=new Integer[nums.length+2][nums.length+2];
       return dfs(1,len-2,rnums,dp);
    }
    public int dfs(int l,int r,int[] rnums,Integer[][] dp){
        if(l>r)
            return 0;
        if(dp[l][r]!=null)
            return dp[l][r];
        dp[l][r]=0;
        for(int i=l;i<=r;i++){
            // value of the result when the last balloon is popped
            int coins=rnums[l-1]*rnums[i]*rnums[r+1];
            // club the result of the subproblems of the two remaining subarrays, also implcitly we know the last element is available for other balloons when they are popped as the baloons outside the range of [l,r] are kept.
            coins+=dfs(l,i-1,rnums,dp)+dfs(i+1,r,rnums,dp);
            dp[l][r]=Math.max(dp[l][r],coins);
        }
        return dp[l][r];
    }
}