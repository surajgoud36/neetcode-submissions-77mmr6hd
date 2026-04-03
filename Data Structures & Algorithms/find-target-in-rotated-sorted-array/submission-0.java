class Solution {
    public int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }


    public int bsearch(int[] nums,int low,int high,int target){
        if(low>high)
            return -1;
        int mid=low+(high-low)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]>target)
            high=mid-1;
        else 
        low=mid+1;
        return bsearch(nums,low,high,target);
    }

    public int search(int[]nums,int low,int high,int target){
         if(low>high)
            return -1;
        // check if it is rotated
        if(nums[low]<nums[high])
            return bsearch(nums,low,high,target);
        int mid=low+(high-low)/2;

        if(nums[mid]==target)
            return mid;
        // determine which half the mid belongs to

        if(nums[mid]>=nums[low]){
            // left sub array where it has bigger elements compared to other sub array
            if(target>=nums[low]&&target<=nums[mid])
                high=mid-1;
            else
                low=mid+1;

        }
        else{
            // right sub array where elements are smaller than the left subarray
            if(target>=nums[mid]&&target<=nums[high])
                 low=mid+1;
            else
                high=mid-1;
        }

        return search(nums,low,high,target);
    }
}