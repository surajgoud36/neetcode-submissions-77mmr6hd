record Pair(char ch,int count){}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(Pair::count).reversed());
        Pair hold=null;
        if(a>0)
            pq.add(new Pair('a',a));
        if(b>0)
            pq.add(new Pair('b',b));
        if(c>0)
            pq.add(new Pair('c',c));
            
        StringBuilder res=new StringBuilder();
        // while(!pq.isEmpty() || hold!=null){
        //     if(pq.isEmpty() && hold==null)
        //         return res.toString();
        //     Pair temp=pq.poll();
        //     res.append(temp.ch());
        //     if(hold!=null){
        //         pq.add(hold);
        //         hold=null;
        //     }
        //     if(temp.count()==1)
        //         continue;
        //     int tempCount=temp.count()-1;
        //     int resLen=res.length();
        //     if(resLen>1 && res.charAt(resLen-1) == res.charAt(resLen-2) && res.charAt(resLen-1)==temp.ch()){
        //         hold=new Pair(temp.ch(),tempCount);
        //     }
        //     else{
        //         pq.add(new Pair(temp.ch(),tempCount));
        //     }
               
        // }
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int resLen=res.length();
            if(resLen>=2 && res.charAt(resLen-1)==res.charAt(resLen-2) && res.charAt(resLen-1)==curr.ch()){
                hold=curr;
                continue;
            }
            res.append(curr.ch());
            if(hold!=null){
                 pq.add(hold);
                 hold=null;
            }
            if(curr.count()>1)
                pq.add(new Pair(curr.ch(),curr.count()-1));
               
        }
        return res.toString();
    }
}