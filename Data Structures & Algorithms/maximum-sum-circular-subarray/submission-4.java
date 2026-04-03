class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        if(nums.length==1)
            return nums[0];
        boolean neg=true;
        for(int x:nums){
             total+=x;
             if(x>0)
                neg=false;
            
        }
           
        int min=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.min(sum+nums[i],nums[i]);
            min=Math.min(min,sum);
        }

        int max=nums[0];
        sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(sum+nums[i],nums[i]);
            max=Math.max(max,sum);
        }
        if(neg)
            return max;
        return Math.max(total-min,max);
    }
}