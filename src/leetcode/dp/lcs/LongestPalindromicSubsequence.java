package leetcode.dp.lcs;
/*Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".


We can see this question as variation of a LCS.
we just reverse the string and then
find the common subsequence using LCS method and the output will be palindromic as we reversed the string.


*/
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s = "agbcba";
        StringBuilder ab = new StringBuilder(s);
        System.out.println(lcs(s,s.length(),ab.reverse().toString(),s.length()));
    }

    private static int lcs(String text1, int n, String text2, int m) {
        int[][] dp = new int[n+1][m+1];


        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i][j-1],
                            dp[i-1][j]
                    );
                }
            }
        }
        return dp[n][m];
    }
}
