class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] copy=Arrays.copyOf(queries,queries.length);
        int[] res=new int[queries.length];
        Arrays.sort(copy);
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<int[]> minH=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int i=0;
        for(int q:copy){
            while(i<intervals.length && q>=intervals[i][0] ){
                int len=intervals[i][1]-intervals[i][0]+1;
                minH.add(new int[]{len,intervals[i][1]});
                i++;
            }
            while(!minH.isEmpty() && q>minH.peek()[1])
                minH.poll();
            if(minH.isEmpty()){
                map.put(q,-1);
            }
            else{
                map.put(q,minH.peek()[0]);
            }
        }
        for(int j=0;j<queries.length;j++){
            res[j]=map.get(queries[j]);
        }
        return res;
    }
}
