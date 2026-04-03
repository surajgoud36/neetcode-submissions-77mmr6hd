class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] y=null;
        if(intervals.length==1)
            res.add(intervals[0]);
        
        for(int i=0;i<intervals.length-1;i++){
            int[] x=intervals[i];
            y=intervals[i+1];
            // if it does not merger with the next
            if(!checkMerge(x[0],x[1],y[0],y[1])){
                res.add(x);
            }
            else{
                y[0]=Math.min(x[0],y[0]);
                y[1]=Math.max(x[1],y[1]);
            }
        }

         if(y!=null)
            res.add(y);
        return res.toArray(new int[res.size()][]);


    }

    

    public boolean checkMerge(int x1,int y1,int x2,int y2){
        if(x1>=x2 && x1<=y2)
            return true;
        if(x2>=x1 && x2<=y1)
            return true;
        if(y1>=x2 && y1<=y2)
            return true;
        if(y2>=x1 && y2<=y1)
            return true;
        return false;
    }
}
