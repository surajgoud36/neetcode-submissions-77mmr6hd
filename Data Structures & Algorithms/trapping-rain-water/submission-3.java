class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1,len=height.length;
        int lmax=height[0];
        int rmax=height[len-1];
        int tot=0;
        while(l<r){
            if(lmax<rmax){
                l++;
                lmax=Math.max(lmax,height[l]);
                
                tot+=lmax-height[l];
                
            }
            else{
                r--;
                rmax=Math.max(rmax,height[r]);
               
                tot+=rmax-height[r];
                
            }
        }
        return tot;
    }
}
