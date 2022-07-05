package leetcode.dp.mcm;

import java.util.Arrays;

public class PalindromePartitionMemoization {

    public static void main(String[] args) {
        // this 501 came from the constraint as it said the lenght will be ==500 so we make it +1 as both i and j will have same range
        int[][] dp = new int[501][501];
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        // As we are just accessing current element the i can start from 0 and j will start from len - 1
        System.out.println(solve("nitik",0,5-1,dp));
    }

    private static int solve(String input, int i, int j, int[][] dp)
    {
        if(i>=j || isPalindrome(input, i , j))  {
            return 0;
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int temp = 1 + solve(input,i,k,dp) + solve(input,k+1,j,dp);
            min = Math.min(min, temp);
        }
        return dp[i][j] = min;
    }

    private static boolean isPalindrome(String input, int i, int j) {
        while(i<j) {
            if(input.charAt(i) != input.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
