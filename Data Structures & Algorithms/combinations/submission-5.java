class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,1,k,new ArrayList<>(),n);
        return res;
    }
    public void dfs(List<List<Integer>> res,int i,int k,List<Integer> cur,int n){
        if(cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int j=i;j<=n;j++){
            cur.add(j);
            dfs(res,j+1,k,cur,n);
            cur.remove(Integer.valueOf(j));
            //dfs(res,j+1,k,cur,n);
        }
    }
}