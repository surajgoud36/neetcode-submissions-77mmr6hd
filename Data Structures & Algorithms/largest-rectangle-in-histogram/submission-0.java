class Solution {
     public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        int left[]=new int[len];
        int right[]=new int[len];

        // for each element track how far it can go either to the left or right with a height >=
        // stop when you have a smaller height

        ArrayDeque<Integer> sh=new ArrayDeque<>();
        sh.push(0);
        left[0]=0;
        for(int i=1;i<len;i++){
            if(heights[sh.peek()]>=heights[i]){
                while(!sh.isEmpty()&&heights[sh.peek()]>=heights[i]){
                    sh.pop();
                }
                if(sh.isEmpty()){
                    left[i]=i;
                    sh.push(i);
                }
                else{
                    left[i]=i-sh.peek()-1;
                    sh.push(i);
                }
            }
            else{
                left[i]=0;
                sh.push(i);
            }
               
            
        }
        sh.clear();
        sh.push(len-1);
        right[len-1]=0;
          for(int i=len-2;i>=0;i--){
            if(heights[sh.peek()]>=heights[i]){
                while(!sh.isEmpty()&&heights[sh.peek()]>=heights[i]){
                    sh.pop();
                }
                if(sh.isEmpty()){
                    right[i]=len-1-i;
                    sh.push(i);
                }
                else{
                    right[i]=sh.peek()-i-1;
                    sh.push(i);
                }
            }
            else{
                right[i]=0;
                sh.push(i);
            }
               
            

        }

        int max=0;
        for(int i=0;i<len;i++){
            max=Math.max(max,heights[i]*(left[i]+right[i]+1));
        }
        return max;
    }
}
