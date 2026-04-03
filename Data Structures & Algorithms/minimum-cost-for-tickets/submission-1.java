class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len=days.length;
        int[] dp=new int[days[len-1]+31];
        //Arrays.fill(dp,-1);
        int index=len-1;
        for(int i=days[len-1];i>=0;i--){
            if(i>days[index])
                dp[i]=dp[i+1];
            if(dp[i]==0)
                dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<costs.length;j++){
                int count=getCount(j);
                dp[i]=Math.min(dp[i],costs[j]+dp[i+count]);
            }
            if(i==days[index])
                index--;
            if(index<0)
                break;
            
        }
        return dp[days[0]];
        //return dfs(days[len-1],dp,len-1,days,costs,days[len-1]);
    }
    public int dfs(int day,int[] dp,int index,int[] days,int[] costs,int lastday){
        if(day>lastday)
            return 0;
        if(dp[day]!=-1)
            return dp[day];
        // we can skip the day if it is greater than the current day
        if(day>days[index])
            dp[day]=dp[day+1];
        for(int i=0;i<costs.length;i++){
            int count=getCount(i);
            
            if(dp[day]==-1){
                dp[day]=costs[0]+dfs(day+1,dp,index,days,costs,lastday);
                continue;
            }
            dp[day]=Math.min(dp[day],costs[i]+dfs(day+count,dp,index,days,costs,lastday));
        }
        if(day==days[index])
            index--;
        if(index<0)
            return dp[day];
        return dfs(day-1,dp,index,days,costs,lastday);
    }
    public int getCount(int i){
        if(i==0)
            return 1;
        if(i==1)
            return 7;
        if(i==2)
            return 30;
        return 0;
    }
}