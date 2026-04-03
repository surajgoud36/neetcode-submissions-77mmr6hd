class Solution {
    public int lastStoneWeightII(int[] stones) {
       List<Integer> list=new ArrayList<>(Arrays.stream(stones).boxed().toList());
       return dfs(list);
    }

    public int dfs(List<Integer> stones){
        if(stones.size()==1)
            return stones.get(0);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<stones.size();i++){
            for(int j=i+1;j<stones.size();j++){
            
                int res=Math.abs(stones.get(j)-stones.get(i));
                List<Integer> next=new ArrayList<>(stones);
                if(res!=0)
                    next.add(res);
                next.remove(j);
                next.remove(i);
                 if(next.size()==0)
                     return 0;
                min=Math.min(min,dfs(next));
                if(min==0)
                    return 0;
               
            }
            
        }
       
        return min;
    }
}