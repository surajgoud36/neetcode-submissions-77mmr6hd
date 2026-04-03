class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        
        int l=0,r=0;
        int target=nums.length-1;
        int min=0;
        while(l<target && r<target && l<=r){
            int maxR=Integer.MIN_VALUE;
            for(int i=l;i<=r;i++){
                if(i+nums[i]>=target)
                    return ++min;
                if(i+nums[i]>r)
                    maxR=Math.max(maxR,i+nums[i]);
            }
            l=r+1;
            r=maxR;
           // System.out.println("l= "+l+" r= "+r);
            min++;
        }
        return 0;
    }
}
