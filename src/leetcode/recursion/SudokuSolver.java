package leetcode.recursion;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='.') {

                    for(char no='1';no<='9';no++) {
                        if(validate(board, i , j , no)) {
                            board[i][j] = no;

                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }

                    }
                    return false;
                }
            }

        }
        return true;
    }


    public boolean validate(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            //checking in row
            if (board[i][col] == c)
                return false;
            //checking in col
            if (board[row][i] == c)
                return false;

            // checking in the box itself
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

}
