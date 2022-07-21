package leetcode.Random;
/*

 https://leetcode.com/problems/word-search/
*
*
* */
public class WordSearch {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}},
                "ABCCED"));
    }


    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                char c = word.charAt(0);
                if(c==board[i][j]) {
                    board[i][j] = '.';

                    boolean result = find(board,word,i-1,j,1)
                            || find(board,word,i+1,j,1)
                            || find(board,word,i,j-1,1)
                            || find(board,word,i,j+1,1);

                    if(result) {
                        return true;
                    }
                    board[i][j] = c;
                }
            }
        }

        return false;

    }


    private static boolean find(char[][] board, String word, int i, int j, int k) {

        if(k==word.length()) {
            return true;
        }


        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='.')         {
            return false;
        }

        char c = word.charAt(k);
        if(c==board[i][j]) {
            board[i][j] = '.';

            boolean result = find(board,word,i-1,j,k+1)
                    || find(board,word,i+1,j,k+1)
                    || find(board,word,i,j-1,k+1)
                    || find(board,word,i,j+1,k+1);

            if(result) {
                return true;
            }
            board[i][j] = c;
        }


        return false;


    }
}
