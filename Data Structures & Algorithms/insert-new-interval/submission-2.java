class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new LinkedList<>();
        boolean flag=false;
        for(int[] interval:intervals){
            if(flag){
                res.add(interval);
                continue;
            }
            if(merge(interval,newInterval))
                newInterval=merger(interval,newInterval);
            else if(newInterval[0]<interval[0]){
                res.add(newInterval);
                res.add(interval);
                flag=true;
            }
            else
                res.add(interval);
        }
        if(!flag)
            res.add(newInterval);
        return res.toArray(new int[res.size()][2]);
    }

    public boolean merge(int[] a,int[] b){
        // a is source
        //b is curr
        if(b[0]>=a[0] && b[0]<=a[1] || b[1]>=a[0] && b[1]<=a[1])
            return true;
         if(a[0]>=b[0] && a[0]<=b[1] || a[1]>=b[0] && a[1]<=b[1])
            return true;
        return false;
    }
    public int[] merger(int[] a,int[] b){
        int[] r=new int[2];
        r[0]=Math.min(a[0],b[0]);
        r[1]=Math.max(a[1],b[1]);
        return r;
    }
}
