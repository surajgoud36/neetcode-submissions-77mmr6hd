class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        map.put(0,1);
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(prefix[i]-k)){
                count+=map.get(prefix[i]-k);
            }
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return count;
    }
}