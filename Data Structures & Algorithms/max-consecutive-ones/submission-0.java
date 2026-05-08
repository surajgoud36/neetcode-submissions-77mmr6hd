class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int l=0,r=0,curr=0;
        for(r=0;r<nums.length;r++){
            if(nums[r]==1)
                {
                    curr++;
                    max=Math.max(curr,max);
                }
                else{
                    curr=0;
                }
        }
        return max;
    }
}