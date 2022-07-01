package leetcode.dp.lcs;

/*
* Given a string 'str' of size ‘n’. The task is to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome. Find the minimum numbers of characters we need to remove.
Note: The order of characters should be maintained.

Example 1:

Input: n = 7, str = "aebcbda"
Output: 2
Explanation: We'll remove 'e' and
'd' and the string become "abcba".
*
*
* We can see this question as LCS variation. To make a string palindromic we first need to find the longest palindromic subsequence
* we can do that using revere os string and then finding LCS and then ans would be
* N - LCS Length = Deletion required.
*
* */
public class MinDeletionsToMakeStringPalindromic {

    public static void main(String[] args) {

        String s = "aebcbda";
        int n = s.length();
        StringBuilder ab = new StringBuilder(s);

       System.out.println(n-lcs(s,n,ab.reverse().toString(),n));
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
