class Solution {
    public boolean search(int[] nums, int target) {
         int len=nums.length;
        
        // check if mid belongs to greater array segment or smaller array segment, 
        //if the mid is part of the greater array segment but not at the juncture we move right,
        //or we move left for any element of the smaller array, as we know that greater array elemets
        // start at the begining of the array and usually the juncture would be towards right and
        // for elements part of the smaller array, the juncture would to be to the left

        int low=0,high=len-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid])
                return true;
            if(nums[mid]==nums[low]){
                low++;
                continue;
            }
            if(nums[mid]<nums[low]){
                // lower half
                if(target==nums[mid])
                    return true;
                else if(target<nums[mid]){
                    high=mid-1;
                    while(nums[high]==nums[high+1])
                        high--;
                }
                   
                else{
                    if(target>=nums[low])
                       { high=mid-1;
                            while(nums[high]==nums[high+1])
                                high--;
                       }
                    else{
                        low=mid+1;
                        while(nums[low]==nums[low-1])
                            low++;
                    }   
                       
                }
                
            }
            else{
                // upper half
                 if(target==nums[mid])
                    return true;
                else if(target>nums[mid]){
                     low=mid+1;
                        while(nums[low]==nums[low-1])
                            low++;
                }
                   
                else{
                    if(target>=nums[low])
                        {
                            high=mid-1;
                            while(nums[high]==nums[high+1])
                                high--;
                        }
                    else
                       {
                            low=mid+1;
                            while(nums[low]==nums[low-1])
                                low++;
                       }
                }
            }
        }
        return false;
    }
}