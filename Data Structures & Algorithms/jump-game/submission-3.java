class Solution {
    public boolean canJump(int[] nums) {
        return check(0,nums,nums.length-1);
    }

    public boolean check(int i,int[] nums,int last){
        if(i+nums[i]>=last)
            return true;
        if(nums[i]==0)
            return false;
        for(int j=nums[i];j>=1;j--){
            if(check(i+j,nums,last))
                return true;
        }
        return false;
    }
}
