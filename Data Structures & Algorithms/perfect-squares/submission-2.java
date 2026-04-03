class Solution {
    public int numSquares(int n) {
        //System.out.println((int)Math.floor(Math.sqrt(n)));
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visit = new HashSet<>();
        q.add(n);
        visit.add(n);
        int len=0;
        while(!q.isEmpty()){
            int l=q.size();
            for(int i=0;i<l;i++){
                int num=q.poll();
                if(num==0)
                    return len;
                int start=1;
                while(start*start<=num){
                    int val=num-(start*start);
                    if(!visit.contains(val)){
                        visit.add(val);
                        q.add(val);
                    }
                    start++;
                }
            }
            len++;
        }
        return -1;

        // int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return dfs(n,dp);
    }
    public int dfs(int n,int[] dp){
        //System.out.println("n= "+n);
        if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        
        int candidate =(int)Math.floor(Math.sqrt(n));
        dp[n]=Integer.MAX_VALUE;
        for(int i=1;i<=candidate;i++){
            dp[n]=Math.min(dp[n],1+dfs(n-(i*i),dp));
        }
        //ystem.out.println("candidate = "+candidate);
        // return 1+(dfs(n-(candidate*candidate)));
        return dp[n];
    }
}