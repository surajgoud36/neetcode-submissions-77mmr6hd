class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            prefix[i]=sum;
        }
        for(int i=0;i<nums.length;i++){
            int leftSum=(i==0)?0:prefix[i-1];
            int rightSum=(i==nums.length-1)?0:prefix[nums.length-1]-prefix[i];
            if(leftSum==rightSum)
                return i;
        }
        return -1;
    }
}