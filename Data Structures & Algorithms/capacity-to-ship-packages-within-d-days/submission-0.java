class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0,min=weights[0];
        for(int x:weights){
            max+=x;
            min=Math.max(min,x);
        }
        // we have the limits
        int low=min,high=max,prev=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int time=1,weight=0;
            for(int w:weights){
                if(weight+w>mid){
                    time++;
                    weight=w;
                }
                else{
                    weight+=w;
                }
            }
            if(time<=days){
                prev=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return prev;
    }
}