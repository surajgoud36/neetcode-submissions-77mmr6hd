class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
    public void quicksort(int[] nums,int s,int e){
        if(e-s+1<=1)
            return;
        int pivot=nums[e];
        int mid=s;
        for(int i=s;i<e;i++){
            if(nums[i]<pivot){
                int temp=nums[i];
                nums[i]=nums[mid];
                nums[mid]=temp;
                mid++;
            }
        }
        nums[e]=nums[mid];
        nums[mid]=pivot;
        quicksort(nums,s,mid-1);
        quicksort(nums,mid+1,e);
    }
}