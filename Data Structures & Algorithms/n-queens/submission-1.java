class Solution {
    List<List<String>> res;
    List<String> path;
    Set<Integer> cols;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
        path=new ArrayList<>();
        cols=new HashSet<>();
        posDiag=new HashSet<>();
        negDiag=new HashSet<>();
        helper(0,n);
        return res;
    }
    public void helper(int index,int n){
        if(index>=n){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<n;i++){
            int col=i;
            int pos=index+i;
            int neg=index-i;
            if(cols.contains(col)||posDiag.contains(pos)|| negDiag.contains(neg))
                continue;
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                if(j!=i)
                    sb.append('.');
                else
                    sb.append('Q');
            }
            path.add(sb.toString());
            cols.add(i);
            posDiag.add(pos);
            negDiag.add(neg);
            helper(index+1,n);
            path.remove(path.size()-1);
            cols.remove(i);
            posDiag.remove(pos);
            negDiag.remove(neg);
        }
    }
}
