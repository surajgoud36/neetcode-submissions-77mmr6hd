class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(n,k,1,path,res);
        return res;
    }
    public void helper(int n,int k,int i,List<Integer> path,List<List<Integer>> res){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
        }
        if(i>n)
            return;
        
        for(int j=i;j<=n;j++){
            path.add(j);
            helper(n,k,j+1,path,res);
            path.remove(Integer.valueOf(j));
        }
    }
}