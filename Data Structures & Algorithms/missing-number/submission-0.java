class Solution {
    public int missingNumber(int[] nums) {
        int res=0;
        for(int x:nums){
            res^=x;
        }
        for(int i=0;i<=nums.length;i++)
            res^=i;
        return res;
    }
}
