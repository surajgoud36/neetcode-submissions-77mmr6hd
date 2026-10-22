class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] lmax = new int[len];
        int[] rmax = new int[len];
        lmax[0] = height[0];
        rmax[len-1] = height[len-1];
        for(int i=1;i<len;i++){
            lmax[i] = Math.max(height[i],lmax[i-1]);
        }
        for(int i=len-2;i>=0;i--){
            rmax[i] = Math.max(height[i],rmax[i+1]);
        }
        int sum =0;
        //System.out.println(Arrays.toString(lmax));
        //System.out.println(Arrays.toString(rmax));
        for(int i=1;i<len-1;i++){
            sum+=Math.min(lmax[i],rmax[i])-height[i];
        }
        return sum;
    }
}
