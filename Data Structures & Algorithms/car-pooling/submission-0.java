record Pair(int capacity,int to){}
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // sort the trips with pickup time
        Arrays.sort(trips,Comparator.comparingInt(p->p[1]));

        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(Pair::to));
        for(int i=0;i<trips.length;i++){
            // check if passengers can be droped off at or before the current location
            while(!pq.isEmpty() && pq.peek().to()<=trips[i][1]){
                Pair temp=pq.poll();
                capacity+=temp.capacity();
            }
            if(trips[i][0]<=capacity){
                pq.add(new Pair(trips[i][0],trips[i][2]));
                capacity-=trips[i][0];
            }
            else{
                return false;
            }
        }

        return true;
    }
}