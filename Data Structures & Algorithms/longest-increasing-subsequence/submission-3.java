class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int max=0;
        for(int i=nums.length-1;i>=0;i--){
            if(map.higherKey(nums[i])==null){
                map.put(nums[i],1);
                max=Math.max(max,1);
            }
            else{
                int len = map.get(map.higherKey(nums[i]));
                map.put(nums[i],len+1);
                max=Math.max(max,len+1);
            }
            while(map.lowerKey(nums[i])!=null && map.get(nums[i])>=map.get(map.lowerKey(nums[i]))){
                map.remove(map.lowerKey(nums[i]));
            }
        }

        return max;

    }
}
