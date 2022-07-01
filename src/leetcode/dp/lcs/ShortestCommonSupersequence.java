package leetcode.dp.lcs;
/*Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.



Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation:
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.

Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"



As we already calculated the length of this by using N+M - LCS Length
to find the exact string we can use the same method to print the LCS.
Just we need to make few changes like whenever we are decrementing i and j we will append them also
and after the loop we will check if any i or j is non 0 then we will run loop again for just them



*/
public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String X = "abcd";
        String Y = "xycd";
        int m = X.length();
        int n = Y.length();
        String ans = lcs(X,m,Y,n);
        System.out.println(ans);
    }
    private static String lcs(String text1, int n, String text2, int m) {

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

        int i = n;
        int j = m;
        StringBuilder ans = new StringBuilder();

        while(i>0 && j>0) {
            if(text1.charAt(i-1)==text2.charAt(j-1)) {
                ans= ans.append(text1.charAt(i-1));
                i--;
                j--;
            } else {
                if(dp[i-1][j]>dp[i][j-1]) {
                    ans= ans.append(text1.charAt(i-1));
                    i--;
                } else {
                    ans= ans.append(text2.charAt(j-1));
                    j--;
                }
            }
        }

        // We do this as above loop will end for any of them zero so the other can be non zero.
        while(i>0) {
            ans= ans.append(text1.charAt(i-1));
            i--;
        }
        // We do this as above loop will end for any of them zero so the other can be non zero.
        while(j>0) {
            ans= ans.append(text2.charAt(j-1));
            j--;
        }

        return ans.reverse().toString();
    }
}
