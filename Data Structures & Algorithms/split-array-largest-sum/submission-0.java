class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        Integer[][] dp=new Integer[n][k+1];
        return dfs(0,k,dp,nums);

    }
    public int dfs(int i,int m,Integer[][] dp,int[] nums){
        if(i==nums.length){
            return m==0? 0:Integer.MAX_VALUE;
        }
           
        if(m<=0){
            dp[i][m]=Integer.MAX_VALUE;
             return dp[i][m];
        }
            
        if(dp[i][m]!=null)
            return dp[i][m];
        // we have to compute
        // we need to basically determine the split
        int n=nums.length;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int ind=i;ind<=n-1-(m-1);ind++){
            sum+=nums[ind];
            int max=Math.max(sum,dfs(ind+1,m-1,dp,nums));
            min=Math.min(min,max);
        }
        dp[i][m]=min;
        return dp[i][m];
    }
}