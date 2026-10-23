class Solution {
    public int jump(int[] nums) {
        int count =0;
        int l=0,r=0;
        while(r<nums.length-1){
            int max=0;
            for(int i=l;i<=r;i++){
                max=Math.max(max,i+nums[i]);
            }
            count++;
            l=r+1;
            r=max;
        }
        return count;
    }
}
