class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int[][] cache=new int[len1][len2];
        for(int[] x:cache){
            Arrays.fill(x,-1);
        }

        return dfs(text1,text2,cache,len1,len2,0,0);
    }

    public int dfs(String s1,String s2,int[][] cache,int len1,int len2,int i1,int i2){
        // base case
        if(i1==len1 || i2==len2)
            return 0;
        if(cache[i1][i2]!=-1)
            return cache[i1][i2];
        if(s1.charAt(i1)==s2.charAt(i2))
            cache[i1][i2]=1+dfs(s1,s2,cache,len1,len2,i1+1,i2+1);
        else
            cache[i1][i2]=Math.max(dfs(s1,s2,cache,len1,len2,i1+1,i2),dfs(s1,s2,cache,len1,len2,i1,i2+1));
        return cache[i1][i2];
    }
}
