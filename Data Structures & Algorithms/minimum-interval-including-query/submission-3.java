class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,Comparator.comparingInt((int[] k)->k[0]).thenComparingInt(k->k[1]));
        List<int[]> qs=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            qs.add(new int[]{queries[i],i});
        }
        qs.sort(Comparator.comparingInt((int[] k)->k[0]));
        int res[]=new int[queries.length];
        //PriorityQueue<int[]> rem=new PriorityQueue<>(Comparator.comparingInt((int[] k)->k[0]));
        PriorityQueue<int[]> curr=new PriorityQueue<>(Comparator.comparingInt((int[] k)->k[1]-k[0]+1));
        // for(int[] interval:intervals){
        //     rem.add(interval);
        // }
        int i=0;
        for(int[] q:qs){
            while(i<intervals.length && q[0]>=intervals[i][0]){
                curr.add(intervals[i]);
                i++;
            }
            while(!curr.isEmpty() && curr.peek()[1]<q[0])
                curr.poll();
            
            
            if(curr.isEmpty()){
                res[q[1]]=-1;
            }
            else{
                res[q[1]]=curr.peek()[1]-curr.peek()[0]+1;
            }
        }
        return res;
    }
}
