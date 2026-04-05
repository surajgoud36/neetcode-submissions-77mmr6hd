class Solution {
    public int mincostTickets(int[] days, int[] costs) {
       // Arrays.sort(days);
       int[] dp = new int[days.length];
       Arrays.fill(dp,-1);
       return dfs(0,dp,costs,days);
    }
    int dfs(int i,int[] dp,int[] costs,int[] days){
        if(i>=days.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        dp[i]=Integer.MAX_VALUE;
        dp[i]=Math.min(dp[i],costs[0]+dfs(i+1,dp,costs,days));
        int temp=i+1;
        while(temp<days.length && days[temp]<(days[i]+7))
            temp++;
        
        dp[i]=Math.min(dp[i],costs[1]+dfs(temp,dp,costs,days));
        while(temp<days.length && days[temp]<(days[i]+30))
            temp++;
        
        dp[i]=Math.min(dp[i],costs[2]+dfs(temp,dp,costs,days));
        return dp[i];
    }
}