class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int max=0;
        for(int i=nums.length-1;i>=0;i--){
            if(map.higherKey(nums[i])==null){
                map.put(nums[i],1);
                max=Math.max(max,map.get(nums[i]));
                while(map.lowerKey(nums[i])!=null && map.get(map.lowerKey(nums[i]))<=map.get(nums[i])){
                    map.remove(map.lowerKey(nums[i]));
                }
            }
            else{
                map.put(nums[i],map.get(map.higherKey(nums[i]))+1);
                max=Math.max(max,map.get(nums[i]));
                while(map.lowerKey(nums[i])!=null&&map.get(map.lowerKey(nums[i]))<=map.get(nums[i])){
                    map.remove(map.lowerKey(nums[i]));
                }
            }
        }
        return max;
    }
}