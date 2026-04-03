class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rows=new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares=new HashMap<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char ch=board[i][j];
                if(ch=='.')
                    continue;
                int row=(int) Math.ceil((i+1)/3.0);
                int col=(int) Math.ceil((j+1)/3.0);
                String key=""+row+col;
                
                squares.computeIfAbsent(key,k-> new HashSet<>());
                rows.computeIfAbsent(i,k-> new HashSet<>());
                cols.computeIfAbsent(j,k-> new HashSet<>());
                if(squares.get(key).contains(ch)||rows.get(i).contains(ch)||cols.get(j).contains(ch))
                    return false;
                squares.get(key).add(ch);
                rows.get(i).add(ch);
                cols.get(j).add(ch);
            }
        }
        return true;
    }
}
