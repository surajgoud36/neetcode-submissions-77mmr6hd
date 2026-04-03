class Solution {
    public int maxProduct(int[] nums) {
        int prevMax=nums[nums.length-1];
        int max=prevMax;
        int maxp=0,maxn=0;
        if(nums.length==1)
            return nums[0];
        maxp=Math.max(nums[nums.length-1],1);
        maxn=Math.min(nums[nums.length-1],1);
        max=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            int res1=nums[i]*maxp;
            int res2=nums[i]*maxn;
            max=Math.max(max,Math.max(res1,res2));
            maxp=Math.max(1,Math.max(res1,res2));
            maxn=Math.min(1,Math.min(res1,res2));
            // if(nums[i]==0){
            //     prevMax=0;
               
            // }
            // else if(sameSign(nums[i],prevMax)){
            //     prevMax*=nums[i];
               
            // }
            // else{
            //     prevMax=nums[i];
            // }
            // max=Math.max(max,prevMax);
        }
        return max;
    }
    public boolean sameSign(int x,int y){
        if(x<0 && y<0)
            return true;
        if(x>0 && y>0)
            return true;
        return false;
    }
}
