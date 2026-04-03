class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        return bsearch(nums,low,high);
    }

    public int bsearch(int[] nums,int low,int high){
        if(low>high)
            return 1001;
        int mid=(low+high)/2;
        // check for min
        int left=mid-1,right=(mid+1)%nums.length;
        if(left==-1)
            left=nums.length-1;
        
        if(nums[mid]<=nums[left] && nums[mid]<=nums[right])
            return nums[mid];
        // check for max
        if(nums[mid]>=nums[left] && nums[mid]>=nums[right]) //<= >=
            return Math.min(nums[left],nums[right]);

        return Math.min(bsearch(nums,low,mid-1),bsearch(nums,mid+1,high));
    }
}
