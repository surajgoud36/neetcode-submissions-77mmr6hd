class Solution {
    public int rob(int[] nums) {
        int odd=0;
        int even=0;
        int max=0;
        int[] arr=new int[2];
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        nums[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            nums[i]=Math.max(nums[i-1],nums[i-2]+nums[i]);
            max=Math.max(max,nums[i]);
        }
        return max;
    }
}
