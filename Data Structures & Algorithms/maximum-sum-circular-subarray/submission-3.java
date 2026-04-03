class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int arraySum=0;
        int checkMax=nums[0];
        boolean neg=true;
        for(int x:nums){
            if(x>=0)
                neg=false;
            arraySum+=x;
            checkMax=Math.max(checkMax,x);
        }
        if(neg)
            return checkMax;
        int min=nums[0],curr=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            curr=Math.min(curr+nums[i],nums[i]);
            min=Math.min(curr,min);
        }
        curr=nums[0];
        for(int i=1;i<nums.length;i++){
            curr=Math.max(curr+nums[i],nums[i]);
            max=Math.max(curr,max);
        }
        return Math.max(arraySum-min,max);
    }
}