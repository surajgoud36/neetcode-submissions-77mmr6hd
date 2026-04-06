class Solution {
    public int trap(int[] heights) {
        int[] lmax=new int[heights.length];
        int[] rmax=new int[heights.length];
        int l=Integer.MIN_VALUE;
        int r=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            l=Math.max(l,heights[i]);
            lmax[i]=l;
        }
        for(int i=heights.length-1;i>=0;i--){
            r=Math.max(r,heights[i]);
            rmax[i]=r;
        }
        int water=0;
        for(int i=1;i<heights.length-1;i++){
            if(heights[i]<lmax[i] && heights[i]<rmax[i]){
                int temp=Math.min(lmax[i],rmax[i])-heights[i];
                System.out.print(temp);
                System.out.print("lmax = "+lmax[i]+" rmax = "+rmax[i]);
                System.out.println(" height = "+heights[i]);
                water+=temp;
            }
        }
        return water;
    }
}
