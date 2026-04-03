class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int x: piles){
            max=Math.max(max,x);
        }
        int min=max;
        return bsearch(piles,h,1,min,min);

    }

    public int determineHours(int[] piles,int k){
        double hrs=0;
        for(int x:piles){
            hrs+=Math.ceil(x/(double)k);
        }
       // System.out.println("determine hrs = "+hrs);
        return (int)hrs;
    }

    public int bsearch(int[] piles,int target,int low,int high,int min){
        if(low>high)
            return min;
        int mid=(low+high)/2;
        int hrs=determineHours(piles,mid);
        //System.out.println("hours= "+hrs+" mid= "+mid);
        // if(hrs==target)
        //     return mid;
         if(hrs>target){
            low=mid+1;
        }
        else{
            min=Math.min(min,mid);
            high=mid-1;
        }
        return bsearch(piles,target,low,high,min);
    }
}
