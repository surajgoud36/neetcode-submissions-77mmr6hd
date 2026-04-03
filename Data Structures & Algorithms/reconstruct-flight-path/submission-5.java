class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets,(a,b)->{
            int cmp=a.get(0).compareTo(b.get(0));
            if(cmp==0)
                return a.get(1).compareTo(b.get(1));
            return cmp; 
        });
        // create an adjacency list
        Map<String,ArrayList<String>> adj=new HashMap<>();
        for(List<String> ticket:tickets){
            String src=ticket.get(0);
            String dst=ticket.get(1);
            adj.computeIfAbsent(src,k->new ArrayList<String>()).add(dst);
        }
        List<String> res=new ArrayList<>();
        //res.add("JFK");
        dfs(adj,"JFK",res,tickets.size());
        Collections.reverse(res);
        return res;
    }
    public void dfs(Map<String,ArrayList<String>> adj, String curr, List<String> res,int len){
        if(!adj.containsKey(curr)){
            res.add(curr);
            return;
        }
        ArrayList<String> q=adj.get(curr);  
        while(!q.isEmpty()){
            String c=q.get(0);
            q.remove(0);
            dfs(adj,c,res,len);
        }
        res.add(curr);
        
        
        // if(res.size()==len+1)
        //     return true;
        // if(!adj.containsKey(curr))
        //     return false;
        // // iterate over its destinations in the pre-computed lexographical order
        // ArrayList<String> temp=new ArrayList<>(adj.get(curr));
        // for(int i=0;i<temp.size();i++){
        //     res.add(temp.get(i));
        //     adj.get(curr).remove(i);
        //     if(dfs(adj,temp.get(i),res,len))
        //         return true;
        //     res.remove(res.size()-1);
        //     adj.get(curr).add(i,temp.get(i));
        // }
        // return false;
    }
}
