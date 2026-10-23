class Solution {
    public int maxSubArray(int[] nums) {
        long sum =Integer.MIN_VALUE,max=Integer.MIN_VALUE;
        for(int x:nums){
            sum=Math.max(sum+x,x);
            max=Math.max(max,sum);
        }
        return max == Integer.MIN_VALUE? -1 : (int)max;
    }
}
