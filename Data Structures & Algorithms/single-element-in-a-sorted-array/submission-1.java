class Solution {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums,0,nums.length-1);
    }
    public int binarySearch(int[] nums,int l,int r){
        if(l>r)
            return -1;
        int mid=l+(r-l)/2;
        //check if its a candidate
        
        if(((mid-1)<0 || nums[mid-1]!=nums[mid]) && ((mid+1)>=nums.length || nums[mid+1]!=nums[mid]))
            return nums[mid];
        int numLeft=mid-0;
        int numRight=nums.length-1-mid;
        if(nums[mid-1]==nums[mid])
            numLeft--;
        if(nums[mid+1]==nums[mid])
            numRight--;
        if(numLeft%2!=0)
            return binarySearch(nums,l,mid-1);
        else
            return binarySearch(nums,mid+1,r);
    }
}