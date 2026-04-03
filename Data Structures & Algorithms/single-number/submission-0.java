class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int x:nums){
            res=res^x;
        }
        return res;
    }
}
