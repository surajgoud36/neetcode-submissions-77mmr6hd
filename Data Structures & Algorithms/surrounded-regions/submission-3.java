class Solution {
    public void solve(char[][] board) {
        // I think we should not consider a zero that has childern or descendants that are border zeros

        int rows=board.length,cols=board[0].length;
        //boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<cols;i++){
            if(board[0][i]=='O')
                dfs(board,0,i);
            if(board[rows-1][i]=='O')
                dfs(board,rows-1,i);
        }
        for(int i=0;i<rows;i++){
            if(board[i][0]=='O')
                dfs(board,i,0);
            if(board[i][cols-1]=='O')
                dfs(board,i,cols-1);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='T')
                    board[i][j]='O';
            }
        }
        // for(int i=0;i<board.length;i++){
        //     for(int j=0;j<board[0].length;j++){
        //         if(board[i][j]=='O'&& i!=0 && i!=rows-1&&j!=0&&j!=cols-1){
        //             if(dfs(board,i,j,visited)==0){
        //                 for(int I=0;I<rows;I++){
        //                     for(int J=0;J<cols;J++){
        //                         if(visited[I][J]){
        //                             visited[I][J]=false;
        //                             board[I][J]='X';
        //                         }
        //                     }
        //                 }
        //             }
        //             else{
        //                 for(int I=0;I<rows;I++){
        //                     for(int J=0;J<cols;J++){
        //                         if(visited[I][J]){
        //                             visited[I][J]=false;
        //                             //board[I][J]='X';
        //                         }
        //                     }
        //                 }
        //             }
        //         }
                    
        //     }
        // }



    }

    public void dfs(char[][] board,int r, int c){
        // check if it is an internal zero, we have a zero now 
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int rows=board.length,cols=board[0].length;
        
        
        if(r<0||r>=rows||c<0||c>=cols||board[r][c]!='O')
            return;
        // check children
        //visited[r][c]=true;
        board[r][c]='T';
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            //System.out.println("r= "+r+" c= "+c);
            //System.out.println("nr= "+nr+" nc= "+nc);
            dfs(board,nr,nc);
            
                
        }
        //visited[r][c]=false;
        //board[r][c]='X';
       // return 0;
    }
}
