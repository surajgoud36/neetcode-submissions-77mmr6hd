class Solution {
    PriorityQueue<Map.Entry<Double,Integer>> pq;
    public int[][] kClosest(int[][] points, int k) {
        pq=new PriorityQueue<>(Map.Entry.comparingByKey(Comparator.reverseOrder()));
       
        for(int i=0;i<points.length;i++){
            int[] point=points[i];
            double distance=distance(point[0],point[1]);
           
            pq.add(new AbstractMap.SimpleEntry<>(distance,i));
            if(pq.size()>k){
                pq.poll();
            }
               
        }

        int[][] res=new int[k][2];
        for(int i=0;i<k;i++){
            res[i]=points[pq.poll().getValue()];
        }
        return res;

    }

    public double distance(int x1,int y1){

        return Math.sqrt(Math.pow(x1-0,2)+Math.pow(y1-0,2));
    }
}
