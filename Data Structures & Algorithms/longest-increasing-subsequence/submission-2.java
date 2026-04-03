class Solution {
    public int lengthOfLIS(int[] nums) {
       TreeMap<Integer,Integer> map = new TreeMap<>();
       int max=0;
       for(int i=nums.length-1;i>=0;i--){
            if(map.higherKey(nums[i])==null){
                map.put(nums[i],1);
                max=Math.max(max,map.get(nums[i]));
            }
            else{
                map.put(nums[i],map.get(map.higherKey(nums[i]))+1);
                max=Math.max(max,map.get(nums[i]));
            }
            while(map.lowerKey(nums[i])!=null && map.get(nums[i])>=map.get(map.lowerKey(nums[i])))
                map.remove(map.lowerKey(nums[i]));
       }
       return max;
    }
    // public int dfs(int[] nums,int index,int[] dp){
    //     if(index>=nums.length)
    //         return 0;
    //     if(dp[index]!=-1 && nums[index]>)
    //         return dp[index];
        
    //     dp[index]=dfs(nums,index+1,dp);
    //     if(index+1==nums.length || nums[index+1]>nums[index])
    //     dp[index]=Math.max(dp[index],dfs())
    // }
}
