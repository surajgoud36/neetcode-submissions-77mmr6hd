class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,Integer> par=new HashMap<>();
        Map<Integer,Integer> rank = new HashMap<>();
        int res[] = new int[2];
        for(int[] edge:edges){
            par.computeIfAbsent(edge[0],k->edge[0]);
            rank.computeIfAbsent(edge[0],k->0);
            par.computeIfAbsent(edge[1],k->edge[1]);
            rank.computeIfAbsent(edge[1],k->0);
            int p1=find(par,edge[0]);
            int p2=find(par,edge[1]);
            if(!union(p1,p2,par,rank)){
                res[0]=edge[0];
                res[1]=edge[1];
            }
        }
        return res;

    }
    public int find(Map<Integer,Integer> par,int curr){
        if(par.get(curr)==curr)
            return curr;
        par.put(curr,find(par,par.get(curr)));
        return par.get(curr);
    }
    public boolean union(int p1,int p2,Map<Integer,Integer> par,Map<Integer,Integer> rank){
        if(p1==p2)
            return false;
        if(rank.get(p1)<rank.get(p2)){
            par.put(p1,p2);
        }
        else if(rank.get(p1)>rank.get(p2))
            par.put(p2,p1);
        else{
            par.put(p2,p1);
            rank.put(p1,rank.get(p1)+1);
        }
        return true;
    }
}
