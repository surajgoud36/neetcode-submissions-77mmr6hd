record Triple(boolean status,int min,int max){}
class Solution {
    public boolean check(int[] nums) {
        if(nums.length==1)
            return true;
        return check1(nums);
    }

    public boolean check1(int[] nums){
        int min=0,max=0;
        boolean dip=false;
        for(int i=1;i<nums.length;i++){
            
            if(nums[i]<nums[i-1]){
                if(!dip){
                    dip=true;
                }
                else
                    return false;
               
            }
            if(dip && nums[i]>nums[0])
                return false;
        }
        return true;
    }
}