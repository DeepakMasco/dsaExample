package leetcode;


import java.util.ArrayList;
import java.util.List;

/*On an 8x8 chessboard, there can be multiple Black Queens and one White King.

Given an array of integer coordinates queens that represents the positions of the Black Queens,
and a pair of coordinates king that represent the position of the White King, return the coordinates of all the
queens (in any order) that can attack the King.*/
public class QueensWhichCanAttackKing {

    public static void main(String[] args) {
        int[][] queens = new int[][] {{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        int[] king = new int[] {3,3};
        List<List<Integer>> queenPositions = findQueens(queens, king);
        queenPositions.forEach(System.out::println);
    }

    private static List<List<Integer>> findQueens(int[][] queens, int[] king) {
        List<List<Integer>> output = new ArrayList<>();

        boolean[][] queenPresent = new boolean[8][8];
        for(int[] queen: queens) {
            queenPresent[queen[0]][queen[1]] = true;
        }

        int[][] possibleMoves = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        for(int i=0;i< possibleMoves.length;i++) {
            int x = king[0] + possibleMoves[i][0];
            int y = king[1] + possibleMoves[i][1];

            while(x>=0 && x<8 && y>=0 && y<8) {
                if(queenPresent[x][y]) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(x);
                    pair.add(y);
                    output.add(pair);
                    break;
                }
                x = x + possibleMoves[i][0];
                y = y + possibleMoves[i][1];
            }
        }

        return output;
    }
}
