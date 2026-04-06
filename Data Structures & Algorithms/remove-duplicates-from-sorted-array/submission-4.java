class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        int l=1;
        int k=0;
        for(int r=1;r<nums.length;r++){
            if(set.contains(nums[r])){
                k++;
            }
            else{
                set.add(nums[r]);
                int temp =nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                l++;
               
            }
        }
        System.out.println(k);
        System.out.println(nums.length-k);
        return nums.length-k;
    }
}