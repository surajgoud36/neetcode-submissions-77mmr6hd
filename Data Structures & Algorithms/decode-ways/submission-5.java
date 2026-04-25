class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return dfs(0,s,dp);
    }
    public int dfs(int i,String s,int[] dp){
        if(i>=s.length())
            return 1;
        if(dp[i]!=-1)
            return dp[i];
        int num1=getNumber(s,i,i);
        if(num1==0 || num1==-1)
            {
                dp[i]=0;
                return 0;
            }
        int sum=dfs(i+1,s,dp);
        int num2=getNumber(s,i,i+1);
        if(num2!=-1){
            //int temp=num1*10+num2;
            if(num2<=26)
              sum+=dfs(i+2,s,dp);
        }
            
        dp[i]=sum;
        return dp[i];
    }
    public int getNumber(String s,int l,int r){
        if(r>=s.length())
            return -1;
        String req=s.substring(l,r+1);
        return Integer.parseInt(req);
    }
}
