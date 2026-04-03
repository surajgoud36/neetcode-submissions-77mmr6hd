class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=nums[0];
        max=Math.max(sum,max);
        for(int i=1;i<nums.length;i++){
            if(sum+nums[i]>nums[i])
                sum+=nums[i];
            else 
                sum=nums[i];
            max=Math.max(sum,max);
        }   
        return max;
    }
}
