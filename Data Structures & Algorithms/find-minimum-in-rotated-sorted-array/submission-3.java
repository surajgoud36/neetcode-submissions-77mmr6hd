class Solution {
    public int findMin(int[] nums) {
        // check if array is roated
        int len=nums.length;
        if(len==1||nums[0]<nums[len-1])
            return nums[0];
        // check if mid belongs to greater array segment or smaller array segment, 
        //if the mid is part of the greater array segment but not at the juncture we move right,
        //or we move left for any element of the smaller array, as we know that greater array elemets
        // start at the begining of the array and usually the juncture would be towards right and
        // for elements part of the smaller array, the juncture would to be to the left

        int low=0,high=len-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<nums[0]){
                // lower half
                if(nums[mid-1]>nums[mid])
                    return nums[mid];
                high=mid-1;
            }
            else{
                // upper half
                if(nums[mid+1]<nums[mid])
                    return nums[mid+1];
                low=mid+1;
            }
        }
        return 0;
    }
}
