class Solution {
    List<List<String>> res;
    Set<Integer> cols;
    Set<Integer> pd;
    Set<Integer> nd;
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
        cols=new HashSet<>();
        pd=new HashSet<>();
        nd=new HashSet<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        dfs(board,0,n,n);
        return res;
    }

    public void dfs(char[][] board,int i,int rows,int columns){
        if(i>=rows){
            List<String> list =new ArrayList<>();
            for(char[] r: board){
                list.add(new String(r));
            }
            res.add(list);
            return;
        }
        for(int j=0;j<columns;j++){
            if(cols.contains(j)||pd.contains(i+j)||nd.contains(i-j))
                continue;
            cols.add(j);
            pd.add(i+j);
            nd.add(i-j);
            board[i][j]='Q';
            dfs(board,i+1,rows,columns);
            board[i][j]='.';
            cols.remove(j);
            pd.remove(i+j);
            nd.remove(i-j);
        }
    }
}
