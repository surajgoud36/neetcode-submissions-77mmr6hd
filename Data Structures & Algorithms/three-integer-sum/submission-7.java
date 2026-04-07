class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<=(nums.length-3);i++){
            if(i!=0 && nums[i-1]==nums[i])
                continue;
            int target=-1*nums[i];
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                
                int currSum=nums[left]+nums[right];
                if(currSum==target){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    while(left<nums.length && nums[left-1]==nums[left]){
                        left++;

                    }
                    
                }
                else if(currSum<target)
                    left++;
                else
                    right--;
            }
            
        }
        return res;
    }
}
