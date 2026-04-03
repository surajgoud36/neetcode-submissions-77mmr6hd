record Triplet(char ch,int nextCycle,int remaining){}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        Queue<Triplet> queue = new ArrayDeque<>();
        PriorityQueue<Triplet> pq=new PriorityQueue<>(Comparator.comparingInt(Triplet::remaining).reversed());
        for(char task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }

        for(Map.Entry<Character,Integer> x:map.entrySet()){
            pq.add(new Triplet(x.getKey(),0,x.getValue()));
        }
        int cycle = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            cycle++;
            if(!queue.isEmpty() && queue.peek().nextCycle==cycle)
                pq.add(queue.remove());
            if(!pq.isEmpty()){
                Triplet curr=pq.poll();
                int rem=curr.remaining()-1;
                if(rem>0){
                    queue.add(new Triplet(curr.ch(),cycle+n+1,rem));
                }
            }
            

        }
        return cycle;
    }
}
