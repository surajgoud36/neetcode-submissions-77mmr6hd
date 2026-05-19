class Solution {
    public int heightChecker(int[] heights) {
        int[] count=new int[101];
        for(int h:heights)
            count[h]++;
        int res=0;
        int index=0;
        for(int i=1;i<101;i++){
            while(count[i]!=0){
                if(heights[index++]!=i)
                    res++;
                count[i]-=1;
            }
        }
        return res;
    }
}