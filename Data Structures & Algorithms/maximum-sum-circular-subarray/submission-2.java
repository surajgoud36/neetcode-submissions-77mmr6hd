class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax=0,gmax=nums[0],currMin=0,gMin=nums[0],total=0;

        for(int x:nums){
            currMax=Math.max(x,currMax+x);
            gmax=Math.max(currMax,gmax);
            currMin=Math.min(x,currMin+x);
            gMin=Math.min(currMin,gMin);
            total+=x;
        }
        System.out.println("Gmax: "+gmax+" gmin: "+gMin);
        if(gmax<0)
            return gmax;
        return gmax>total-gMin? gmax:total-gMin;
    }
}