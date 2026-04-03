class Solution {
    List<List<String>> res;
    List<String> path;
    Set<Integer> cols;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    int count;
    public int totalNQueens(int n) {
        res=new ArrayList<>();
        path=new ArrayList<>();
        cols=new HashSet<>();
        posDiag=new HashSet<>();
        negDiag=new HashSet<>();
        count=0;
        helper(0,n);
        return count;
    }
    public void helper(int index,int n){
        if(index>=n){
            count++;
            return ;
        }
        for(int i=0;i<n;i++){
            int col=i;
            int pos=index+i;
            int neg=index-i;
            if(cols.contains(col)||posDiag.contains(pos)|| negDiag.contains(neg))
                continue;
            
            //path.add(sb.toString());
            cols.add(i);
            posDiag.add(pos);
            negDiag.add(neg);
            helper(index+1,n);
            //path.remove(path.size()-1);
            cols.remove(i);
            posDiag.remove(pos);
            negDiag.remove(neg);
        }
    }
}
