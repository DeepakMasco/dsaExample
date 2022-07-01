package leetcode.dp.lcs;
/*Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both, X and Y as its sub-sequences.
Note: X and Y can have both uppercase and lowercase letters.

Example 1

Input:
X = abcd, Y = xycd
Output: 6
Explanation: Shortest Common Supersequence
would be abxycd which is of length 6 and
has both the strings as its subsequences.


This question is similar to LCS.
What we will do is first find the LCS and then we need to append the characters before and after of LCS from both string to generate the sequence.
So the length will be simply lenght of LCS + leftover length of both string.
or Len1 + Len2 - LCS length


*/
public class ShortestCommonSupersequenceLength {

    public static void main(String[] args) {

        String X = "abcd";
        String Y = "xycd";
        int m = X.length();
        int n = Y.length();
        int len = lcs(X,m,Y,n);
        int ans = m + n - len;
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
