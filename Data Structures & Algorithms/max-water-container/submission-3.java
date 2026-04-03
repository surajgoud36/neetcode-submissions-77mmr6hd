class Solution {
    public int maxArea(int[] height) {
        int max=Integer.MIN_VALUE;
        int l=0,h=height.length-1;
        while(l<h){
            int area=(h-l)*Math.min(height[l],height[h]);
            max=Math.max(max,area);
            if(height[l]<=height[h])
                l++;
            else
                h--;
        }
        return max;
    }
}