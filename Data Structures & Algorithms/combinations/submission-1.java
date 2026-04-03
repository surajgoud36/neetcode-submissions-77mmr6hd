class Solution {
    List<List<Integer>> glo;
    public List<List<Integer>> combine(int n, int k) {
        glo=new ArrayList<>();
        helper(n,k,new ArrayList<>(),1);
        return glo;
    }

    public void helper(int n,int k, List<Integer> list,int i){
        
        if(list.size()==k){
           // System.out.println(list);
            glo.add(new ArrayList<>(list));
            return;
        }
        if(i>n)
            return;

            for(int j=i;j<=n;j++){
                list.add(j);
                helper(n,k,list,j+1);
                list.remove(list.size()-1);
            }
        // list.add(i);
        // helper(n,k,list,i+1);
        // list.remove(list.size()-1);
        // helper(n,k,list,i+1);
    }
}