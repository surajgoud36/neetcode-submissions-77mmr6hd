record Pair<K,V>(K Key, V value){}
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //Map<Integer,Integer
        Map<Pair<Integer,Integer>,Integer> cache=new HashMap<>();
        return dfs(nums,0,0,target,cache);
        
    }
    public int dfs(int[]nums,int i,int sum,int target, Map<Pair<Integer,Integer>,Integer> cache){
        if(i>=nums.length){
            if(sum==target)
                return 1;
            return 0;
        }
        Pair<Integer,Integer> p=new Pair<>(i,sum);
        if(cache.containsKey(p))
            return cache.get(p);
        int max=dfs(nums,i+1,sum+nums[i],target,cache)+dfs(nums,i+1,sum-nums[i],target,cache);
        cache.put(p,max);
        return max;
    }
}
