class Solution {
    public void solve(char[][] board) {
        // I think we should not consider a zero that has childern or descendants that are border zeros

        int rows=board.length,cols=board[0].length;
        boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'&& i!=0 && i!=rows-1&&j!=0&&j!=cols-1){
                    if(dfs(board,i,j,visited)==0){
                        for(int I=0;I<rows;I++){
                            for(int J=0;J<cols;J++){
                                if(visited[I][J]){
                                    visited[I][J]=false;
                                    board[I][J]='X';
                                }
                            }
                        }
                    }
                    else{
                        for(int I=0;I<rows;I++){
                            for(int J=0;J<cols;J++){
                                if(visited[I][J]){
                                    visited[I][J]=false;
                                    //board[I][J]='X';
                                }
                            }
                        }
                    }
                }
                    
            }
        }



    }

    public int dfs(char[][] board,int r, int c,boolean[][] visited){
        // check if it is an internal zero, we have a zero now 
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int rows=board.length,cols=board[0].length;
        
        if(board[r][c]=='X' || visited[r][c])
            return 0;
        if(r==0||r==rows-1||c==0||c==cols-1)
            return -1;
        // check children
        visited[r][c]=true;
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            //System.out.println("r= "+r+" c= "+c);
            //System.out.println("nr= "+nr+" nc= "+nc);
            int res=dfs(board,nr,nc,visited);
            if(res==-1){
                visited[r][c]=false;
                return -1;
            }
                
        }
        //visited[r][c]=false;
        //board[r][c]='X';
        return 0;
    }
}
