class Solution {
    public int maxSubArray(int[] nums) {
        int l=0,r=0;
        int max=nums[0];
        int sum=nums[0];
        for(r=1;r<nums.length;r++){
            if(sum<0){
                sum=0;
                l=r;
            }
            sum+=nums[r];
            max=Math.max(sum,max);
        }
        return max;
    }
}
