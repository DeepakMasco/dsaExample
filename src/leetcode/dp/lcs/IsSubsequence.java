package leetcode.dp.lcs;
/*Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
*/
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequenceLcs("abc",3,"ahbgdc",6));
    }

    //In the below appraoch we will find out the LCS and if text1 is present in text2 then lenght of LCS = length of text1.
    // Hence we check if it is not equal we return false.
    private static boolean isSubsequenceLcs(String text1, int n, String text2, int m) {
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
            return dp[n][m]==n?true:false;
    }

    // We are using simple 2 pointer appraoch.
    // We will just keep on iterating over string 2 till the time we get string 1 char.
    // In last if string1 is totally traversed then true else false.
    public static boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        while(n>0 && m>0) {
            if(s.charAt(n-1)==t.charAt(m-1)) {
                n--;
                m--;
            } else {
                m--;
            }
        }

        return n==0? true:false;

    }
}
