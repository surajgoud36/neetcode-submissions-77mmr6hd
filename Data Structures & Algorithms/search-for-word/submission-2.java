record Pair(int r,int c){}
class Solution {
    public boolean exist(char[][] board, String word) {
        Set<Pair> set= new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board,word,set,0,i,j))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board,String word,Set<Pair> set,int index,int row,int col){
        if(index==word.length()){
            return true;
        }
        // check out of boounds
        if(row>=board.length || col>=board[0].length || row<0 ||  col<0)
            return false;
        if(!set.contains(new Pair(row,col)) && board[row][col]==word.charAt(index)){
            Pair p =new Pair(row,col);
            set.add(p);
            if(helper(board,word,set,index+1,row,col+1) || helper(board,word,set,index+1,row,col-1) ||
               helper(board,word,set,index+1,row+1,col)||helper(board,word,set,index+1,row-1,col))
               return true;
            set.remove(p);
            return false;
        }
        return false;
    }
}
