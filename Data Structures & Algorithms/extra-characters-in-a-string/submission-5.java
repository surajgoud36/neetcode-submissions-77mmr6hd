class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> words =new HashSet<>(Arrays.asList(dictionary));
		int[] dp=new int[s.length()];
		Arrays.fill(dp,-1);
		return dfs(0,dp,s,words);
    }
	public int dfs(int i,int[] dp,String s,Set<String> words){
		if(i>=s.length())
			return 0;
		if(dp[i]!=-1)
			return dp[i];
		int min=1+dfs(i+1,dp,s,words);
		for(int j=i;j<s.length();j++){
			String curr=s.substring(i,j+1);
			if(words.contains(curr)){
				min=Math.min(min,dfs(j+1,dp,s,words));
			}
		}
		dp[i]=min;
		return dp[i];
	}
}