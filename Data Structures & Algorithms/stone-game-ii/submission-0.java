class Solution {
    public int stoneGameII(int[] piles) {
        Map<List<Integer>,Integer> dp = new HashMap<>();
        return dfs(dp,1,piles,0,piles.length,1);
    }
    public int dfs( Map<List<Integer>,Integer> dp,int turn,int[] piles,int i,int len,int m){
        if(i>=len)
            return 0;
        //m=Math.min(m,len-i);
        List<Integer> cur= new ArrayList<>(Arrays.asList(turn,i,m));
        if(dp.containsKey(cur))
            return dp.get(cur);
        int max=0;
        int curr=0;
        int min=Integer.MAX_VALUE;
        for(int j=i;j<Math.min(len,i+(2*m));j++){
            if(turn==1){
                curr+=piles[j];
                //curr+=dfs(dp,2,piles,j+1,len,Math.max(m,j-i+1));
                max=Math.max(max,curr+dfs(dp,2,piles,j+1,len,Math.max(m,j-i+1)));
            }
            else{
                //curr+=dfs(dp,1,piles,j+1,len,Math.max(m,j-i+1));
                min=Math.min(min,dfs(dp,1,piles,j+1,len,Math.max(m,j-i+1)));
            }
           

        }
        if(turn==1)
            dp.put(cur,max);
        else
            dp.put(cur,min);
        return dp.get(cur);
       // return max;
        
    }
}