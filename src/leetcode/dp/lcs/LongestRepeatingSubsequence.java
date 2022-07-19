package leetcode.dp.lcs;
/*Given a string str, find the length of the longest repeating subsequence such that it can be found twice
in the given string. The two identified subsequences A and B can use the same ith character f
rom string str if and only if that ith character has different indices in A and B.

Example 1:

Input:
str = "axxzxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x z x y
0 1 2 3 4 5

The longest subsequence is "xx".
It appears twice as explained below.

subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of str


subsequence B
x x
0 1  <-- index of subsequence B
------
2 4  <-- index of str

We are able to use character 'x'
(at index 2 in str) in both subsequences
as it appears on index 1 in subsequence A
and index 0 in subsequence B.

Example 2:

Input:
str = "axxxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x x y
0 1 2 3 4

The longest subsequence is "xx".
It appears twice as explained below.

subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of str


subsequence B
x x
0 1  <-- index of subsequence B
------
2 3  <-- index of str

We are able to use character 'x'
(at index 2 in str) in both subsequences
as it appears on index 1 in subsequence A
and index 0 in subsequence B.*/
public class LongestRepeatingSubsequence {

    public static void main(String[] args) {
        String s = "aabebcdd";
        int n = s.length();
        System.out.println(lcs(s,n,s,n));
    }


    private static int lcs(String text1, int n, String text2, int m) {

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                    // Here we are adding one extra condition for i!=j as we don't want to match the same letter and same index
                    // for the subsequence as we cannot use it again. Hence we add it. And the below else condition
                    // will take care of not repeating the char in the ans as we are only using one char.
                } else if(text1.charAt(i-1)==text2.charAt(j-1) && i!=j) {
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
