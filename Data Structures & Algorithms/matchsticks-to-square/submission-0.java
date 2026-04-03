class Solution {
    public boolean makesquare(int[] matchsticks) {
       int total=0;
       for(int x:matchsticks)
            total+=x;
        if(total%4!=0)
            return false;
        int target = total/4;
        int[] sides=new int[4];
        reverse(matchsticks);
        return dfs(matchsticks,sides,0,target);
    }
    public boolean dfs(int[] matchsticks,int[] sides,int index,int targetLength){
        if(index==matchsticks.length)
            return true;
        for(int i=0;i<4;i++){
            if(sides[i]+matchsticks[index]<=targetLength){
                sides[i]+=matchsticks[index];
                if(dfs(matchsticks,sides,index+1,targetLength))
                    return true;
                sides[i]-=matchsticks[index];
            }
            while(i!=3 && sides[i]==sides[i+1])
                i++;
            
        }
        return false;
    }
    private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }
}