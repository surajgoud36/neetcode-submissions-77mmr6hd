class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int x:stones){
            pq.add(x);
        }

        while(pq.size()>1){
            int stone1=pq.poll();
            int stone2= pq.poll();
            if(stone1-stone2!=0){
                pq.add(stone1-stone2);
            }
        }
        if(pq.size()==0)
            return 0;
        else
            return pq.peek();
    }
}
