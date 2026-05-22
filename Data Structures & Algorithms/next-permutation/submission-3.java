class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==1)
            return;
        int pivot=findPivot(nums);
        if(pivot==-1){
            reverse(nums,0);
            return;
        }
        int nextGreater=nextGreater(nums,nums[pivot]);
        int temp=nums[pivot];
        nums[pivot]=nums[nextGreater];
        nums[nextGreater]=temp;
        reverse(nums,pivot+1);
    }
    public int findPivot(int[] nums){
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1])
                return i-1;
        }
        return -1;
    }
    public int nextGreater(int[] nums,int ele){
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>ele)
                return i;
        }
        return -1;
    }
    public void reverse(int[] nums,int start){
        int l=start,r=nums.length-1;
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }

    }
}