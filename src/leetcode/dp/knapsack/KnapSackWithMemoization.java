package leetcode.dp.knapsack;

import java.util.Arrays;

public class KnapSackWithMemoization {

    public static void main(String[] args) {

        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }

        System.out.println(knapSack(W, wt, val, n,dp));


    }


    static int knapSack(int W, int wt[], int val[], int n, int[][] dp)
    {
        // your code here
        if (n==0 || W==0) {
            return 0;
        }
        if (dp[n][W]!=-1) {
            return dp[n][W];
        }
        if (wt[n-1]<=W) {
            return dp[n][W] = Math.max(
                    val[n-1]+knapSack(W-wt[n-1],wt,val,n-1, dp),
                    knapSack(W,wt,val,n-1, dp)
            );
        }

        return dp[n][W] = knapSack(W,wt,val,n-1,dp);

    }
}
