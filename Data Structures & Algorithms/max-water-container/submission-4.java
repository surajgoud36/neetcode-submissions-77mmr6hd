class Solution {
    public int maxArea(int[] heights) {
        int l=0,r=heights.length-1;
        int max=Integer.MIN_VALUE;
        while(l<r){
            int currH=Math.min(heights[l],heights[r]);
            max=Math.max(max,(r-l)*currH);
            if(heights[l]<=heights[r])
                l++;
            else
                r--;
        }
        return max;
    }
}
