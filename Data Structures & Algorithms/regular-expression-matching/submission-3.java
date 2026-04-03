class Solution {
    public boolean isMatch(String s, String p) {
        int len1=s.length();
        int len2=p.length();
        Boolean[][] dp=new Boolean[len1+1][len2+1];
        boolean[] dp1=new boolean[len2+1];
        dp1[len2]=true;
        for(int i=len2-1;i>=0;i--){
            if(i<len2-1 && p.charAt(i+1)=='*')
                dp1[i]=dp1[i+1];
            else if(p.charAt(i)=='*')
                dp1[i]=dp1[i+1];
        }
        for(int i=0;i<len2;i++)
            dp[len1][i]=false;
        for(int i=0;i<len1;i++)
            dp[i][len2]=false;
        dp[len1][len2]=true;
        Character prev=null;
        for(int i=len1-1;i>=0;i--){
            boolean[] curr=new boolean[len2+1];
            for(int j=len2-1;j>=0;j--){
                if(p.charAt(j)=='.'){
                    //prev='.';
                    curr[j]=dp1[j+1];
                    if(j!=len2-1 && p.charAt(j+1)=='*')
                        curr[j]=curr[j]||curr[j+1];
                    //dp1[j]=dp1[j+1];
                }
                else if(p.charAt(j)=='*'){
                    prev=p.charAt(j-1);
                    if(prev!='.' && prev!=s.charAt(i))
                        curr[j]=curr[j+1];
                    else
                        curr[j]=dp1[j]||dp1[j+1]||curr[j+1];
                    //dp1[j]=dp1[j]||dp1[j+1];
                }
                else{
                    if(s.charAt(i)!=p.charAt(j))
                        curr[j]=false;
                    else
                      curr[j]=dp1[j+1];
                    if(j!=len2-1 && p.charAt(j+1)=='*')
                        curr[j]=curr[j]||curr[j+1];
                    //dp1[j]=dp1[j+1];
                   // prev=p.charAt(j);
                }
            }
            //dp1[len2]=false;
            dp1=curr;
        }
        return dp1[0];
    }
   // public boolean dfs(String s,int i1,String p,int i2)
}