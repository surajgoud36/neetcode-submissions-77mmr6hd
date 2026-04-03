class Solution {
    public int searchInsert(int[] nums, int target) {
        int prev=0;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                prev=mid;
                break;
            }
            else if(nums[mid]>target){
                high=mid-1;
                prev=high+1;
            }
            else{
                low=mid+1;
                prev=low;
            }
        }
        if(prev==-1)
            return 0;
        return prev;
    }
}