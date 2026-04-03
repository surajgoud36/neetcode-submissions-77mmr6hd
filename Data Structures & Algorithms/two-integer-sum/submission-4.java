class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]),i};
            map.put(nums[i],i);
        }
        // for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        //     if(map.containsKey(target-entry.getKey()) && map.get(target-entry.getKey())!=entry.getValue())
        //         return new int[]{entry.getValue(),map.get(target-entry.getKey())};
        // }
        return new int[0];
    }
}
