class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        boolean allNegative=true;
        for(int x:nums){
            total+=x;
            if(x>=0)
                allNegative=false;
        }
            
        int min=nums[0],sum=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.min(sum+nums[i],nums[i]);
            min=Math.min(min,sum);
        }
        sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(sum+nums[i],nums[i]);
            max=Math.max(max,sum);
        }
        if(allNegative)
            return max;
        return Math.max(max,total-min);
    }
}