class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt((int[] x)->x[0]).thenComparingInt(x->x[1]));
        int count=0;
        int[] temp=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] interval=intervals[i];
            if(canMerge(temp,interval)){
                count++;
                if(temp[1]>interval[1])
                    temp=interval;
            }
            else{
                temp=interval;
            }
        }
        return count;
    }

    public boolean canMerge(int[] parent,int[] child){
        int s1=parent[0],e1=parent[1];
        int s2=child[0],e2=child[1];
        if(e1>s2)
            return true;
        return false;
        // if(s2>s1 && s2<e1 || e2>s1 && e2<e1)
        //     return true;
        // if(s1>s2 && s1<e2 || e1>s2 && e1<e2)
        //     return true;
        // return false;
    }
}
