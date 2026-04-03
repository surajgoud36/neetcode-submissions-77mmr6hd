class Solution {
    public int numDecodings(String s) {
        // Map<String,Character> map = new HashMap<>();
        // for(int i=1;i<=26;i++){
        //     char ch= (char)((int)'a'+i-1);
        //     map.put(String.valueOf(i),ch);
        // }
        //System.out.println(map);
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return dfs(0,dp,s);
    }

    public int dfs(int index,int[] dp,String s){
        if(index>=s.length())
            return 1;
        if(dp[index]!=-1)
            return dp[index];
        if(s.charAt(index)=='0'){
            dp[index]=0;
            return 0;
        }
        if((index+1)<=s.length()){
            dp[index]=dfs(index+1,dp,s);
        }
        if((index+2)<=s.length()){
            String curr=s.substring(index,index+2);
            int num=Integer.parseInt(curr);
            if(num<=26){
                dp[index]+=dfs(index+2,dp,s);
            }

        }
       return dp[index];
    }
}
