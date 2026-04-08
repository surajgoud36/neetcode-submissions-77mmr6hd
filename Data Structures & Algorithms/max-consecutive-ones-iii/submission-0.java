class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        int l=0,r=0;
        int zero=0;
        for(r=0;r<nums.length;r++){
            if(nums[r]==0){
                if(zero<k){
                    zero++;
                }
                else{
                    while(l<r && nums[l]!=0)
                        l++;
                    l++;
                }
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}