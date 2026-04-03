class Solution {
    public int[] sortArray(int[] nums) {
        // implementing quick sort that works in O(n logn) and O(1) space
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums,int s,int e){
        if(e<s||e-s<=0)
            return;
        // assuming the pivot to be nums[e];
        int pivot=nums[e];
        int left=s;
        for(int i=s;i<=e;i++){
            if(nums[i]<pivot){
                int temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
                left++;
            }
        }
        nums[e]=nums[left];
        nums[left]=pivot;
        quickSort(nums,s,left-1);
        quickSort(nums,left+1,e);
    }
}