class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int tot=0;
        for(int x: cardPoints){
            tot+=x;
        }
        int size=cardPoints.length-k;
        int currSum=0;
        for(int i=0;i<size;i++){
            currSum+=cardPoints[i];
        }
        int min=currSum;
       // System.out.println(size+" "+cardPoints.length+" "+min+" "+tot);
        if(size==0)
            return tot;
        for(int i=size;i<cardPoints.length;i++){
            currSum-=cardPoints[i-size];
            currSum+=cardPoints[i];
            min=Math.min(min,currSum);
        }
        return tot-min;
    }
}