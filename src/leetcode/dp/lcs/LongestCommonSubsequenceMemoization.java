package leetcode.dp.lcs;


/*Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
*/


import java.util.Arrays;

public class LongestCommonSubsequenceMemoization {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        System.out.println(lcs(text1,n,text2,m,dp));
    }

    private static int lcs(String text1, int n, String text2, int m, int[][] dp) {
        if(n==0 || m==0) {
            return 0;
        }
        if(dp[n][m]!=-1) {
            return dp[n][m];
        }
        if(text1.charAt(n-1)==text2.charAt(m-1)) {
            return dp[n][m] = 1 + lcs(text1,n-1,text2,m-1,dp);
        } else {
            return dp[n][m] = Math.max(
                    lcs(text1,n-1,text2,m,dp),
                    lcs(text1,n,text2,m-1,dp)
            );
        }
    }
}
