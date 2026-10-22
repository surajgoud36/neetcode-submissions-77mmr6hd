class Solution {
    public int findMin(int[] nums) {
        int low =0,high=nums.length-1;
        if(nums[0]<nums[high])
            return nums[0];
        while(low<=high){
            if(low == high)
                return nums[low];
             int mid = low + (high-low) /2;
            if(nums[mid]<nums[0] && (mid+1 == nums.length || nums[mid]<nums[mid+1])&&(nums[mid]<nums[mid-1]))
                return nums[mid];

            if(nums[mid]>=nums[0])
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}
