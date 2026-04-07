class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt((int[] a)->a[0]).thenComparingInt(a->a[1]));
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{intervals[0][0],intervals[0][1]});
        int ind=0;
        for(int i=1;i<intervals.length;i++){
            int[] prev=res.get(ind);
            int[] curr=intervals[i];
            if(curr[0]>=prev[0] && curr[0]<=prev[1]){
                prev[0]=Math.min(prev[0],curr[0]);
                prev[1]=Math.max(prev[1],curr[1]);
            }   
            else{
                res.add(curr);
                ind++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
