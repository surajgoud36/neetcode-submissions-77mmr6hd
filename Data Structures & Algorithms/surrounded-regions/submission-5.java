class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0;i<rows;i++){
            if(board[i][0] == 'O')
                dfs(board,i,0);
            if(board[i][cols-1]=='O')
                dfs(board,i,cols-1);
        }
        for(int i=0;i<cols;i++){
            if(board[0][i] == 'O')
                dfs(board,0,i);
            if(board[rows-1][i]=='O')
                dfs(board,rows-1,i);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='H')
                    board[i][j] = 'O';
            }
        }
        
    }
    public void dfs(char[][] board,int i,int j){
        board[i][j]='H';
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:directions){
            int nr = i+dir[0];
            int nc=j+dir[1];
            if(Math.min(nr,nc)<0 || nr==board.length || nc==board[0].length||board[nr][nc]!='O')
                continue;
            dfs(board,nr,nc);
        }
    }
}
