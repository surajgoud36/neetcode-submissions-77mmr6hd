class Solution {
    public int maxProduct(int[] nums) {
        int len=nums.length;
        int maxP=nums[len-1];
        int pos=Math.max(nums[len-1],1);
        int neg=Math.min(nums[len-1],1);
        for(int i=len-2;i>=0;i--){
            int p1=nums[i]*pos;
            int p2=nums[i]*neg;
            maxP=Math.max(maxP,nums[i]);
            maxP=Math.max(maxP,Math.max(p1,p2));
            pos=Math.max(Math.max(Math.max(p1,p2),1),nums[i]);
            neg=Math.min(Math.min(Math.min(p1,p2),1),nums[i]);
        }
        return maxP;
    }
}
