class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
            return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:hand){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());
        int grp=0;
        while(!pq.isEmpty()){
            int start = pq.peek();
            if(map.get(start)==1){
                 pq.poll();
                 map.remove(start);
            }
            else
                map.put(start,map.get(start)-1);  
            for(int i=1;i<groupSize;i++){
                if(map.containsKey(start+1)){
                    start=start+1;
                    if(map.get(start)==1 && pq.peek()!=start)
                        return false;
                    if(map.get(start)==1){
                        pq.poll();
                        map.remove(start);
                    }
                    else{
                        map.put(start,map.get(start)-1);  
                    }

                }
            }
            grp++;
        }
        if(grp!=hand.length/groupSize)
            return false;
        return true;
    }
}
