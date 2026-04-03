class Solution {
    public boolean isValidSudoku(char[][] board) {

        return checkRows(board)&&checkCols(board)&&checkSquares(board);
    }

    public boolean checkRows(char[][] board) {
        int[] count = new int[10];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(count, 0);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (count[board[i][j] - '0'] != 0)
                        return false;
                    else
                        count[board[i][j] - '0']++;
                }
            }
        }
        return true;
    }

    public boolean checkCols(char[][] board) {
        int[] count = new int[10];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(count, 0);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (count[board[j][i] - '0'] != 0)
                        return false;
                    else
                        count[board[j][i] - '0']++;
                }
            }
        }
        return true;
    }

    public boolean checkSquares(char[][] board) {
        int row = 0, col = 0;
        int[] count = new int[10];
        while (row < 9) {
            col = 0;
            while (col < 9) {
                Arrays.fill(count, 0);
                for (int i = row; i < row+3; i++) {
                   
                    for (int j = col; j < col+3; j++) {
                        if (board[i][j] != '.') {
                            if (count[board[i][j] - '0'] != 0)
                                return false;
                            else
                                count[board[i][j] - '0']++;
                        }
                    }
                }
                col+=3;
            }
            row+=3;
        }
        return true;
    }
}
