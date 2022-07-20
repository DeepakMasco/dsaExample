package leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/n-queens/submissions/
public class NQueen {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        solveNQueens(n,ans);
        return ans;
    }

    public void solveNQueens(int n, List<List<String>> ans) {
        char[][] board = new char[n][n];
        for(char[] row: board) {
            Arrays.fill(row,'.');
        }

        dfs(board,ans,0);
    }

    public boolean validate(char[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;

        // We will be checking in only left 3 directions as there is no queen in right side and up or down.

        // left above level
        while(row>=0 && col>=0) {
            if(board[row][col]=='Q') return false;
            col--;
            row--;
        }

        //left same level
        col = dupCol;
        row = dupRow;
        while(col>=0) {
            if(board[row][col]=='Q') return false;
            col--;
        }

        //left bottom
        col = dupCol;
        row = dupRow;
        while(row<board.length && col>=0) {
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }

        return true;

    }

    public void dfs(char[][] board, List<List<String>> ans, int col) {
        if(col==board.length) {
            ans.add(constructBoard(board));
            return;
        }


        for(int row=0;row<board.length;row++) {
            if(validate(board,row,col)) {
                board[row][col] = 'Q';
                dfs(board,ans,col+1);
                board[row][col] = '.';
            }
        }
    }

    public List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
