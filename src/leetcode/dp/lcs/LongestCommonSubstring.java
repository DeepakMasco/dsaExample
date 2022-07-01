package leetcode.dp.lcs;
/*
* Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input Sequences
“ABCDGH” and “AEDFHR” is “ADH” of
length 3.
*
*
*
* In this the appraoch will remain same. Just we will not have any else condition to iterate we will simply make it 0
* And at every matching step we will check our max and current max. and then which ever is greater we keep that and return that in last.
* One thing to notice here dp[n][m] will not give the ans as that will just store that last char is matching or not.
* or like till last character how many common char came.
*/
public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println(lcsDp("ABCDGH",6,"AEDFHR",6));
    }

    private static int lcsDp(String text1, int n, String text2, int m) {

        int[][] dp = new int[n+1][m+1];
        int max = 0;

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
