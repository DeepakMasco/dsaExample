package leetcode;

import java.util.Arrays;
/*
*  https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
*
* Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down.
* You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).



Example 1:

Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

*
* */
public class LongestIncreasingPathInMatrix {

    public static void main(String[] args) {
    longestIncreasingPath(new int[][]
            {{3,4,5},
            {3,2,6},
            {2,2,1}});
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] output = new int[row][col];

        for(int[] row1: output) {
            Arrays.fill(row1,1);
        }

        int max = 1;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {

                //top
                if(i-1>=0) {
                    if(matrix[i-1][j] > matrix[i][j]) {
                        output[i][j] = Math.max(output[i-1][j]+1, output[i][j]);
                    }
                }
                //bottom
                if(i+1<row) {
                    if(matrix[i+1][j] > matrix[i][j]) {
                        output[i][j] = Math.max(output[i+1][j]+1, output[i][j]);
                    }

                }
                //left
                if(j-1>=0) {
                    if(matrix[i][j-1] > matrix[i][j]) {
                        output[i][j] = Math.max(output[i][j-1]+1, output[i][j]);
                    }

                }
                // right
                if(j+1<col) {
                    if(matrix[i][j+1] > matrix[i][j]) {
                        output[i][j] = Math.max(output[i][j+1]+1, output[i][j]);
                    }

                }

                if(output[i][j]>max) {
                    max = output[i][j];
                }

                System.out.print(output[i][j]);

            }
            System.out.println();
        }

        return max;

    }
}
