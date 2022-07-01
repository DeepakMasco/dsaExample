package leetcode.dp.lcs;

public class PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int n = text1.length();
        int m = text2.length();


        System.out.println(lcs(text1,n,text2,m));
    }

    private static String lcs(String text1, int n, String text2, int m) {
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
                    i--;
                } else {
                    j--;
                }
            }
        }

        return ans.reverse().toString();
    }
}
