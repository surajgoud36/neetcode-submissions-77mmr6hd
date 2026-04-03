class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int targetIndex=Math.abs(nums[i])-1;
            if(nums[targetIndex]>0){
                nums[targetIndex]*=-1;
                continue;
            }
            else{
                return Math.abs(nums[i]);
            }
               
            
        }
        return -1;
    }
}
