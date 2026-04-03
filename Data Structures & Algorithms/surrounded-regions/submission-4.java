class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {
        //directions=new int{{0,1},{0,-1},{1,0},{-1,0}};
        int rows=board.length;
        int cols=board[0].length;
        for(int i=0;i<cols;i++){
            if(board[0][i]=='O')
                dfs(0,i,board);
            if(board[rows-1][i]=='O')
                dfs(rows-1,i,board);
        }
         for(int i=0;i<rows;i++){
            if(board[i][0]=='O')
                dfs(i,0,board);
            if(board[i][cols-1]=='O')
                dfs(i,cols-1,board);
        }
         for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='H')
                    board[i][j]='O';
            }
         }
    }

    public void dfs(int r,int c,char[][] board){
        board[r][c]='H';
        for(int dir[]:directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(Math.min(nr,nc)<0 || nr==board.length || nc==board[0].length || board[nr][nc]!='O')
                continue;
            dfs(nr,nc,board);
        }
    }
}