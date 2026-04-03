record Pair(double dist,int index){}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<>(Comparator.comparingDouble(Pair::dist).reversed());
        int ind=0;
        for(int[] point:points){
            double distanceFromOrigin = distance(point);
            if(pq.size()<k)
                pq.add(new Pair(distanceFromOrigin,ind));
            else if(pq.peek().dist()>distanceFromOrigin){
                pq.poll();
                pq.add(new Pair(distanceFromOrigin,ind));
            }
            ind++;
        }

        int[][] res=new int[k][2];
        ind=0;
        for(Pair p:pq){
            res[ind++]=points[p.index()];
        }
        return res;

    }

    public double distance(int[] point){
        int x=point[0];
        int y=point[1];
        return Math.sqrt((x*x)+(y*y));
    }
}
