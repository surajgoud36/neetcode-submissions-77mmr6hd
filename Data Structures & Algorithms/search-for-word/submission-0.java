class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length, cols=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(board,i,j,rows,cols,"",word,0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,int r,int c,int rows,int cols,String curr,String word,int index){
        // base case
        if(r<0||r>=rows||c<0||c>=cols||board[r][c]=='*'||board[r][c]!=word.charAt(index))
            return false;
        curr+=board[r][c];
        char temp=board[r][c];
        if(index==word.length()-1 && curr.equals(word))
            return true;
        board[r][c]='*';
        
        // else
        //     return false;
        if(dfs(board,r+1,c,rows,cols,curr,word,index+1))
            return true;
        if(dfs(board,r-1,c,rows,cols,curr,word,index+1))
            return true;
        if(dfs(board,r,c+1,rows,cols,curr,word,index+1))
            return true;
        if(dfs(board,r,c-1,rows,cols,curr,word,index+1))
            return true;
        board[r][c]=temp;
        return false;
    }
}
