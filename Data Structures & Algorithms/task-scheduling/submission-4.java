class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0)
            return tasks.length;
        int[] count=new int[26];
        for(char ch:tasks){
            count[ch-'A']++;
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(Map.Entry.comparingByKey(Comparator.reverseOrder()));
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                pq.add(new AbstractMap.SimpleEntry<>(count[i],0));
            }
        }
        Queue<Map.Entry<Integer,Integer>> q = new ArrayDeque<>();

        int counter=0;
        while(!q.isEmpty() || !pq.isEmpty()){
            counter++;
            if(!q.isEmpty()){
                Map.Entry<Integer,Integer> ent=q.peek();
                if(ent.getValue()==counter){
                    pq.add(q.poll());
                }
            }
            if(!pq.isEmpty()){
                Map.Entry<Integer,Integer> ent=pq.poll();
                if(ent.getKey()==1){
                    // wont do anything
                }
                else{
                    q.add(new AbstractMap.SimpleEntry<>(ent.getKey()-1,counter+n+1));
                }
            }
        }
        return counter;
    }
}
