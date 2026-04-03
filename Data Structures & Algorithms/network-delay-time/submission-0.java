class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Dijkstra algorithm application

        // lets construct an adjacency list
        Map<Integer,ArrayList<Integer[]>> adj=new HashMap<>();
        for(int i=1;i<=n;i++)
            adj.put(i,new ArrayList<Integer[]>());
        for(int[] edge:times){
            int src=edge[0],dst=edge[1],wt=edge[2];
            adj.get(src).add(new Integer[]{dst,wt});
        }


        int max=-1;

        Map<Integer,Integer> res=new HashMap<>();
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((n1,n2)->(Integer.compare(n1[0],n2[0])));
        minHeap.add(new int[]{0,k});
        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int n1=curr[1],w1=curr[0];
            if(res.containsKey(n1))
                continue;
            res.put(n1,w1);
            max=Math.max(max,w1);
            for(Integer[] children:adj.get(n1)){
                int n2=children[0],w2=children[1];
                if(!res.containsKey(n2))
                    minHeap.add(new int[]{w1+w2,n2});
            }
        }
        if(res.size()<n)
            return -1;
        return max;
    }
}
