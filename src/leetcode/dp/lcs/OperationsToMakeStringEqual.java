package leetcode.dp.lcs;
/*Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.



Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4


This is also similar to supersequence length.
To make 2 words equal we will delete all extra charaters from words except the LCS.
so ans would be N-LCS + M - LCS --> N+M-2*LCS Length

No of Insertions -> N-Len of LCS
No Of Deletions -> M - Len of LCS

*/
public class OperationsToMakeStringEqual {

    public static void main(String[] args) {
        String X = "abcd";
        String Y = "xycd";
        int m = X.length();
        int n = Y.length();
        int len = lcs(X,m,Y,n);
        int ans = m + n - 2*len;
        System.out.println(ans);
    }

    private static int lcs(String text1, int n, String text2, int m) {

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if(text1.charAt(i-1)==text2.charAt(j-1)) {
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
