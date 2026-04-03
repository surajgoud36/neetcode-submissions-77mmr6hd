class Solution {
    int maxProduct;
    public int maxProduct(int[] nums) {
        maxProduct=-11;
        int maxP=1,maxN=1;
        for(int i=nums.length-1;i>=0;i--){
            // int temp1=maxP;
            // int temp2=maxN;
            if(nums[i]==0){
                maxProduct=Math.max(0,maxProduct);
                maxP=1;
                maxN=1;
                continue;
            }
            int temp1=nums[i]*maxP;
            int temp2=nums[i]*maxN;
            maxProduct=Math.max(Math.max(temp1,temp2),Math.max(maxProduct,nums[i]));
            maxP=Math.max(Math.max(temp1,temp2),Math.max(1,nums[i]));
            maxN=Math.min(Math.min(temp1,temp2),Math.min(1,nums[i]));
           // maxProduct=Math.max(Math.max(maxP,maxN),maxProduct);
            // maxP=Math.max(Math.max(temp1,temp2),nums[i]);
            // temp1=Math.min(maxN*nums[i],1);
            // temp2=Math.min(maxP*nums[i],1);
            // maxN=Math.min(Math.min(temp1,temp2),nums[i]);
            // maxProduct=Math.max(Math.max(maxP,maxN),maxProduct);
        }
        return maxProduct;
    }

    // public int dfs(int[] nums,int index,int[] dp,int currProduct){

    //     if(index>nums.length)
    //         return 1;
    //     if(dp[index]!=-1)
    //         return dp[index];
    //     if(nums[index]>)
    // }
}
