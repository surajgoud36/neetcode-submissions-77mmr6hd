class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //lets do this 
        int l=0,sum=0,min=Integer.MAX_VALUE;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            if(sum>=target){
                min=Math.min(min,r-l+1);
                sum-=nums[l];
                sum-=nums[r];
                l++;
                r--;
            }
            else{

            }
        }
        if(min==Integer.MAX_VALUE)
            return 0;
        return min;
    }
}