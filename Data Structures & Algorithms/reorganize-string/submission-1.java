record Pair(int rem,char letter,int pop){}
class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        for(char ch:s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);

        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(Pair::rem).reversed());
        Queue<Pair> queue=new ArrayDeque<>();
        StringBuilder res=new StringBuilder();
        for(Map.Entry<Character,Integer> entry: freq.entrySet()){
            pq.add(new Pair(entry.getValue(),entry.getKey(),0));
        }

        int i=0;
        //System.out.println("pq= "+pq);
        while(!pq.isEmpty()||!queue.isEmpty()){
            i++;
            if(pq.isEmpty() && queue.peek().pop()!=i )
                break;
            if(!queue.isEmpty() && queue.peek().pop()==i)
                pq.add(queue.poll());
            Pair temp=pq.poll();
            res.append(temp.letter());
            if(temp.rem()>1){
                queue.add(new Pair(temp.rem()-1,temp.letter(),i+2));
            }
            //System.out.println("res = "+res.toString());
        }
        if(res.length()!=s.length())
            return "";
        return res.toString();
    }
}