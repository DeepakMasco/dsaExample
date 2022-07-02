package leetcode.dp.mcm;

import java.util.Arrays;
/*Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.

The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).

Example 1:

Input: N = 5
arr = {40, 20, 30, 10, 30}
Output: 26000
Explaination: There are 4 matrices of dimension
40x20, 20x30, 30x10, 10x30. Say the matrices are
named as A, B, C, D. Out of all possible combinations,
the most efficient way is (A*(B*C))*D.
The number of operations are -
20*30*10 + 40*20*10 + 40*10*30 = 26000.

*/
public class McmMemoization {

    public static void main(String[] args) {
        int[] arr = new int[] {40, 20, 30, 10, 30};
        int n = arr.length;

        // Here the size of array will depend on the max lenght of array. This will be given in question.
        // So if 100 is the limit we do limit +1 = 101 as size. And as both i and j are in the size limit so it will square matrix
        int[][] dp = new int[101][101];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println(solve(arr,1,n-1,dp));
    }

    static int solve(int[] arr, int i, int j, int[][] dp) {
        // we make >= as if i and j are equal means there is only one matrix.
        // Hence there will no multiply and cost will be 0 only.
        if(i>=j) {
            return 0;
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        int temp = 0;

        //When we break the arr using K there will be 2 calls made.
        //solve(i,k) and solve(k+1,j). This range can vary and we need to verify
        // If we start k from i then in first range we get arr[o] and arr[1]
        // So this will give us one valid matrix.
        // and k=j is also valid as we get one valid matrix.
        // But our range starts from k+1 so we will just keep k<j
        for(int k=i;k<j;k++) {
            // As we already calculated the cost of left and right part./
            // We add them and we need to add the cost of this calc.
            temp = solve(arr,i,k,dp) + solve(arr,k+1,j,dp) + arr[i-1] * arr[k] * arr[j];
            min = Math.min(temp,min);

        }

        return dp[i][j] = min;
    }
}
