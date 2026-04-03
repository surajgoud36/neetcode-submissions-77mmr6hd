class Solution {
    public int maxArea(int[] heights) {
         //while moving from left to right and right to left just keep track of the highest ones
        int len=heights.length;
        int lmax=0;
        int rmax=len-1;
        int left=0,right=len-1,max=0;
        while(left<right){
            if(heights[left]<=heights[right]){
                //left height smaller than or equal to
                int area=heights[left]*(right-left);
                max=Math.max(max,area);
                left++;
            }
            else{
                int area=heights[right]*(right-left);

                 max=Math.max(max,area);
                 right--;
            }
            // else if(height[left]<=height[rmax])
        }
        return max;
    }
}
