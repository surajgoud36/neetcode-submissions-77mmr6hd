class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // binary search solution

        int max=piles[0];
        for(int x:piles){
            max=Math.max(x,max);
        }
        int low=1,high=max,min=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(piles,mid,h)){
                min=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return min;

    }
    public boolean check(int[] piles,int rate,int h){
        int count=0;
        for(int x:piles){
            count+=Math.ceil(x/(double)rate);
        }
        if(count>h)
            return false;
        return true;    
    }
}
