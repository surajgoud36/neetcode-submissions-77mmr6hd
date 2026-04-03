class Solution {
    int sum;
    public int subsetXORSum(int[] nums) {
        sum=0;
        helper(nums,0,0);
        return sum;
    }

    public void helper(int[] nums, int index,int xor){
        if(index==nums.length){
            sum+=xor;
            return;
        }
        helper(nums,index+1,xor^nums[index]);
        helper(nums,index+1,xor);
    }
}