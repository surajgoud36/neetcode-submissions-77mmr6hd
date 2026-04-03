class Solution {
    public int search(int[] nums, int target) {
          int len=nums.length;
        if(len==1||nums[0]<nums[len-1])
            return normalSearch(nums,target);
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
                if(target==nums[mid])
                    return mid;
                else if(target<nums[mid])
                    high=mid-1;
                else{
                    if(target>=nums[0])
                        high=mid-1;
                    else
                        low=mid+1;
                }
                
            }
            else{
                // upper half
                 if(target==nums[mid])
                    return mid;
                else if(target>nums[mid])
                    low=mid+1;
                else{
                    if(target>=nums[0])
                        high=mid-1;
                    else
                        low=mid+1;
                }
            }
        }
        return -1;
    }
    public int normalSearch(int[] nums,int target){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}
