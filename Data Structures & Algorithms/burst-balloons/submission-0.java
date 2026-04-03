class Solution {
    public int maxCoins(int[] nums) {
        Map<List<Integer>,Integer> map=new HashMap<>();
        List<Integer> rem=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        for(int i=0;i<nums.length;i++)
            rem.add(nums[i]);
        
        return dfs(nums,rem,map);
    }

    public int dfs(int[] nums,List<Integer> rem, Map<List<Integer>,Integer> map){
        if(rem.size()==1)
            {
                return rem.get(0);
               // return 0;
            }

        if(map.containsKey(rem))
            return map.get(rem);
        int max=0;
        for(int i=0;i<rem.size();i++){
                int n1=(i-1 == -1)? 1:rem.get(i-1);
                int n2=(i+1==rem.size())?1:rem.get(i+1);
                int prod=n1*n2*rem.get(i);
                int val=rem.get(i);
                rem.remove(i);
                
                max=Math.max(max,prod+dfs(nums,rem,map));
              
                rem.add(i,val);
            
        }
        List<Integer> k=new ArrayList<>(rem);
        map.put(k,max);
        return max;
    }
}