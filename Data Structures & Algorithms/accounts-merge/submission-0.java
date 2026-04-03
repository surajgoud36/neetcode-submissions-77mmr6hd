class UnionFind{
    Map<Integer,Integer> par;
    Map<Integer,Integer> rank;

    public UnionFind(int n){
        par=new HashMap<>();
        rank=new HashMap<>();

        for(int i=0;i<n;i++){
            par.put(i,i);
            rank.put(i,0);
        }
    }

    public int find(int x){
        // also invlolves path compression
        if(x!=par.get(x))
            par.put(x,find(par.get(x)));
        return par.get(x);
    }

    public boolean union(int n1,int n2){
        int p1=find(n1),p2=find(n2);
        if(p1==p2)
            return false;
        if(rank.get(p1)>rank.get(p2)){
             par.put(p2,p1);
        }
        else if(rank.get(p1)<rank.get(p2)){
             par.put(p1,p2);
        }
        else{
            par.put(p2,p1);
            rank.put(p1,rank.get(p1)+1);
        }
        return true;
    }
}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf=new UnionFind(accounts.size());
        Map<String,Integer> emails=new HashMap<>();
        int outer=0;
        for(List<String> account:accounts){
            for(int j=1;j<account.size();j++){
                String s=account.get(j);
                if(emails.containsKey(s)){
                    uf.union(outer,emails.get(s));
                }
                else{
                    emails.put(s,outer);
                }
            }
            outer++;
        }
        Map<Integer,List<String>> group=new HashMap<>();
        for(Map.Entry<String,Integer> entry:emails.entrySet()){
            int leader=uf.find(entry.getValue());
            group.computeIfAbsent(leader,k->new ArrayList<>()).add(entry.getKey());
        }
        List<List<String>> res=new ArrayList<>();
        for(int k:group.keySet()){
            String name=accounts.get(k).get(0);
            List<String> list=group.get(k);
            Collections.sort(list);
            list.add(0,name);
            res.add(list);
        }
        return res;
    }
    // we add all the emails with their paretns 
}