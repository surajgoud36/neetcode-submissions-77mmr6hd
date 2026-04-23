class Solution {
    public void nextPermutation(int[] nums) {
       int pivot=findPivotIndex(nums);
       if(pivot==-1){
             reverse(nums,0,nums.length-1);
             return;
       }
           
        int nextGreater=findNextGreater(nums,pivot);
        int temp=nums[pivot];
        nums[pivot]=nums[nextGreater];
        nums[nextGreater]=temp;
        reverse(nums,pivot+1,nums.length-1);
    }
    public int findPivotIndex(int[] nums){
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1])
                return i-1;
        }
        return -1;
    }
    public int findNextGreater(int[] nums,int ind){
        for(int i=nums.length-1;i>ind;i--){
            if(nums[i]>nums[ind])
                return i;
        }
        return -1;
    }

    public void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}