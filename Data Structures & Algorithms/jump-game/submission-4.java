class Solution {
    public boolean canJump(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        set.add(nums.length-1);
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=nums.length-1||set.floor(nums[i]+i)!=null)
                set.add(i);
            
        }
        if(set.contains(0))
            return true;
        return false;
    }
}
