class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        helper(n,k,1,res,path);
        return res;
    }
    public void helper(int n,int k,int ind, List<List<Integer>> res,List<Integer> path){
        if(path.size()>=k){
            res.add(new ArrayList<>(path));
            return;
        }
        if(ind>n)
            return;
        for(int i=ind;i<=n;i++){
            path.add(i);
            helper(n,k,i+1,res,path);
            path.remove(Integer.valueOf(i));
        }
            
    }
}