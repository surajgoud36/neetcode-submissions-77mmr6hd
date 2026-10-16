class Solution {
    public List<List<String>> partition(String s) {
        //your code goes here
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++)
            dp[i][i] = true;
        
        for(int l=1;l<=n;l++){
            // each length from 1 to length
            for(int i=0;i<=n-l;i++){
                dp[i][i+l-1]=(s.charAt(i) == s.charAt(i+l-1) && ((i+1>(i+l-2)) || dp[i+1][i+l-2]));
            }
        }
        System.out.println(Arrays.deepToString(dp));
       return dfs(s,dp,0);
    }
    public List<List<String>> dfs(String s,boolean[][] dp,int i){
        if(i>=s.length())
            return new ArrayList<List<String>>() {{ add(new ArrayList<>()); }};
        List<List<String>> ret = new ArrayList<>();
        for(int j=i;j<s.length();j++){
            if(dp[i][j]){
                List<List<String>> nxt = dfs(s,dp,j+1);
                for(List<String> part : nxt){
                    List<String> curr = new ArrayList<>();
                    curr.add(s.substring(i,j+1));
                    curr.addAll(part);
                    ret.add(curr);
                }
            }
        }
        return ret;
    }
}
