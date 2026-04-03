class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        boolean check=true;
       // int[] prev;
    //    if(intervals.length==0)
    //         res.add(newInterval);
        for(int[] x:intervals){
            // check for merge
           // prev=x;
            if(check && checkMerge(x[0],x[1],newInterval[0],newInterval[1])){
                newInterval[0]=Math.min(x[0],newInterval[0]);
                newInterval[1]=Math.max(x[1],newInterval[1]);
            }
            else if(check){
                if(x[0]<newInterval[0])
                    res.add(x);
                else{
                    res.add(newInterval);
                    check=false;
                    res.add(x);
                }
            }
            else{
                res.add(x);
                //prev=null;
            }
        }
        if(check)
            res.add(newInterval);

        int[][] res1=new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            res1[i]=new int[]{res.get(i)[0],res.get(i)[1]};
        }
        //return res.toArray(new int[0]);
        return res1;
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
