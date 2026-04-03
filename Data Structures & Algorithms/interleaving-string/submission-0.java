class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len=s3.length();
        if(len1+len2!=len)
            return false;
        Boolean[][] dp=new Boolean[len1][len2];

        
        return dfs(dp,s1,s2,0,0,s3,0);
    }

    public boolean dfs(Boolean[][] dp,String s1,String s2,int i1,int i2,String s3,int i){
        // basecase
        if(i1==s1.length() && i2==s2.length() && i==s3.length())
            return true;
        if(i1>=s1.length())
            return s2.substring(i2).equals(s3.substring(i));
        if(i2>=s2.length())
            return s1.substring(i1).equals(s3.substring(i));
        
        if(dp[i1][i2]!=null)
            return dp[i1][i2];
        // recursive logic
        dp[i1][i2]=false;
        if(i1<s1.length() && s1.charAt(i1)==s3.charAt(i))
            dp[i1][i2]=dp[i1][i2]||dfs(dp,s1,s2,i1+1,i2,s3,i+1);
        if(i2<s2.length() && s2.charAt(i2)==s3.charAt(i))
            dp[i1][i2]=dp[i1][i2]||dfs(dp,s1,s2,i1,i2+1,s3,i+1);
        return dp[i1][i2];
        
    }
}