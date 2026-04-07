class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        tickets.sort(Comparator.comparing((List<String> l)->l.get(0)).thenComparing(l->l.get(1)));
        List<String> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(List<String> ticket:tickets){
            map.computeIfAbsent(ticket.get(0),k->new ArrayList<>()).add(ticket.get(1));
        }
        int target=tickets.size()+1; // n-1 edges, n nodes
        return dfs("JFK",map,res,target);
    }
    public List<String> dfs(String city,Map<String,List<String>> map,List<String> res,int target){
        res.add(city);
        if(map.containsKey(city)){
            List<String> cities = map.get(city);
            for(int i=0;i<cities.size();i++){
                String dst=cities.get(i);
                cities.remove(i);
                List<String> tres=dfs(dst,map,res,target);
                if(tres.size()==target)
                    return tres;
                cities.add(i,dst);
            }
        }
        if(res.size()==target)
            return res;
        res.remove(res.size()-1);
        return res;
    }
}
