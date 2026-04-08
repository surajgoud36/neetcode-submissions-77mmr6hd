class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0,h=nums.length-1;
        boolean lastH=false;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target){
                 h=mid-1;
                 lastH=true;
            }
               
            else{
                l=mid+1;
                lastH=false;
            }
                
        }
        if(lastH)
            return h==-1?0:h+1;
        return l;

    }
}