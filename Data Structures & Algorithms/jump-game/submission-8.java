class Solution {
    public boolean canJump(int[] nums) {
        
        int len = nums.length;
       
        int next = len-1;
        for(int i=len-2;i>=0;i--){
            if(i+nums[i]>= next){
               // System.out.println(i+" "+nums[i]+" "+next);
                next=i;
            }
        }
        return next == 0;
    }
}
