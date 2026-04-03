class Solution {
     public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int count=0;
        if(intervals.length==1)
            return count;
        int[] curr=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] x=intervals[i];
            //int[] y=intervals[i+1];
            if(check(curr[0],curr[1],x[0],x[1])){
                count++;
                if((curr[1]>=x[1]))
                    curr=x;
            }
                
            else{
                curr=x;
            }
        }
        return count;


    }

    public boolean check(int x1,int x2,int y1,int y2){
        if(x1>=y1 && x1<=y2)
            return true;
        if(x2>y1 && x2<=y2)
            return true;
        if(y1>=x1 && y1<x2)
            return true;
        if(y2>=x1 && y2<=x2)
            return true;
        return false;
    }
}
