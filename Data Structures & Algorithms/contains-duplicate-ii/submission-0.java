class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        //lets do this for mom
        Set<Integer> set=new HashSet<>();
        int l=0,r=0;
        for(r=0;r<nums.length;r++){
            if(set.size()==k+1){
                set.remove(nums[l]);
                l++;
            }
            if(set.contains(nums[r]))
                return true;
            set.add(nums[r]);
        }
        return false;
    }
}