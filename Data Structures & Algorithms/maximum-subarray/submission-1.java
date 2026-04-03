class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0],currSum=nums[0];
        for(int i=1;i<nums.length;i++){
            currSum=Math.max(currSum+nums[i],nums[i]);
            max=Math.max(currSum,max);
        }
        return max;
    }
}
