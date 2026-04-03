class Solution {
    public int findDuplicate(int[] nums) {
       for(int i=0;i<nums.length;i++){
            int ind=Math.abs(nums[i]);
            if(nums[ind-1]<0)
                return ind;
            nums[ind-1]*=-1;
       }
       return 0;
    }
}
