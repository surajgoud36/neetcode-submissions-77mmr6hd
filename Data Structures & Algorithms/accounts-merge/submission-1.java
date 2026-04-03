class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String,Integer> emailParent=new HashMap<>();
        Map<Integer,Integer> rank=new HashMap<>();
        Map<Integer,Integer> indexParent=new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            rank.put(i,0);
            indexParent.put(i,i);
            List<String> account=accounts.get(i);
            for(int j=1;j<account.size();j++){
                String email=account.get(j);
                if(emailParent.containsKey(email)){
                    int existingParent=findParent(emailParent.get(email),indexParent);
                    union(existingParent,findParent(i,indexParent),rank,indexParent);
                }
                else{
                    emailParent.put(email,findParent(i,indexParent));
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        Map<Integer,List<String>> group = new HashMap<>();
       // System.out.println("email parent map "+emailParent);
        for(Map.Entry<String,Integer> entry : emailParent.entrySet()){
            int leader=findParent(entry.getValue(),indexParent);
            group.computeIfAbsent(leader,k-> new ArrayList<>()).add(entry.getKey());
        }
        for(int k:group.keySet()){
            String name=accounts.get(k).get(0);
            List<String> list=group.get(k);
            Collections.sort(list);
            list.add(0,name);
            res.add(list);
        }
        return res;
    }
    public int findParent(int parent,Map<Integer,Integer> indexParent){
        if(parent!=indexParent.get(parent))
            indexParent.put(parent,findParent(indexParent.get(parent),indexParent));
        return indexParent.get(parent);
    }
    public void union(int p1,int p2,Map<Integer,Integer> rank,Map<Integer,Integer> indexParent){
        if(p1==p2)
            return;
        if(rank.get(p1)>rank.get(p2))
            indexParent.put(p2,p1);
        else if(rank.get(p1)<rank.get(p2))
            indexParent.put(p1,p2);
        else{
            indexParent.put(p2,p1);
            rank.put(p1,rank.get(p1)+1);
        }

    }
}