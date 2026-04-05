class Solution {
    record Pair(int[] rem,int status){}
    int max;
    public int findMaxForm(String[] strs, int m, int n) {
        Map<List<Integer>,Integer> dp = new HashMap<>();
        max=0;
        return dfs(dp,0,m,n,strs,0);
        
    }
    public int dfs(Map<List<Integer>,Integer> dp,int i,int m,int n,String[] strs,int currSize){
        if(m==0 && n==0){
           
            return 0;
        }
        if(i>=strs.length){
            return 0;
        }
        List<Integer> curr = new ArrayList<>(Arrays.asList(i,m,n));
        if(dp.containsKey(curr))
            return dp.get(curr);
        int skip=dfs(dp,i+1,m,n,strs,currSize);
        Pair check = canInclude(strs[i],m,n);
        if(check.status()==1){
            skip=Math.max(1+dfs(dp,i+1,check.rem()[0],check.rem()[1],strs,currSize+1),skip);
        }
        dp.put(curr,skip);
        return skip;
    }   

    public Pair canInclude(String s,int m,int n){
        int zero=0,one=0;
        for(char ch:s.toCharArray()){
            if(ch=='0')
                zero++;
            else
                one++;
        }
        if(zero<=m && one<=n){
            return new Pair(new int[]{m-zero,n-one},1);
        }
        return new Pair(new int[]{m,n},0);
    }
}