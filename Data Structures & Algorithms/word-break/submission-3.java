class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // bottom up DP solution 
        boolean[] dp=new boolean[s.length()+1];
        dp[s.length()]=true;
        for(int i=s.length()-1;i>=0;i--){
            // for each index check if it matches any of the word in wordDict to the right 
            for(String w:wordDict){
                // check if we have those many letters or length as w to compare against
                if(i+w.length()<=s.length() && s.substring(i,i+w.length()).equals(w))
                    dp[i]=dp[i+w.length()];
                if(dp[i])
                    break;
            }
        }
        return dp[0];
    }
}
