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
public class LongestCommonSubsequenceRecursive {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int n = text1.length();
        int m = text2.length();

        System.out.println(lcs(text1,n,text2,m));
    }
/*
* Here we think of smallest input for BC which is if both the length of string = 0 then ans would be 0
* Then we check if last character is mathing for both string we decrease the lenght of both string and add 1 as we got 1 matching character.
* Then we need to think if char does not match . Either we can decrease lenght of 1 and let the lenght of other remain same.
* Hence we get below two cases and in both cases whatever ans we get we need the max from the same.
*
* */
    private static int lcs(String text1, int n, String text2, int m) {
        if(n==0 || m==0) {
            return 0;
        }

        if(text1.charAt(n-1)==text2.charAt(m-1)) {
            return 1 + lcs(text1,n-1,text2,m-1);
        } else {
            return Math.max(
                    lcs(text1,n-1,text2,m),
                    lcs(text1,n,text2,m-1)
            );
        }

    }
}
