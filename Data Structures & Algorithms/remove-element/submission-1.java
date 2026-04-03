class Solution {
    public int removeElement(int[] nums, int val) {
        int l=0,r=nums.length-1;
        int count=0;
        if(nums.length==0)
            return 0;
        while(true){
            while(r>=0 && nums[r]==val){
            r--;
            count++;
            }
            while(l<r && nums[l]!=val){
                l++;
            }
            if(l==r || l>r)
                break;
            // swap
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            
        }
        return nums.length-count;
       
    }
}