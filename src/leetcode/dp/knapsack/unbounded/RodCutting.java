package leetcode.dp.knapsack.unbounded;
/*Given a rod of length N inches and an array of prices, price[] that contains prices of all pieces of size smaller than N. Determine the maximum value obtainable by cutting up the rod and selling the pieces.



Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and
6, i.e., 5+17=22.




This is a question on unbounded knapsack. As we can cut the rod of same length again and again till the time profit is coming maximum.
So we just use the knapsack code but here we will not decrement the array size if we select it. As it will be available again.
And we just map the prices to value array and lenght to weight array. And rest of the code remains same.

*/
public class RodCutting {

    public static void main(String[] args) {
        System.out.println(cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 8));
    }

    public static int cutRod(int price[], int n) {

        int len = price.length;
        int[] cut = new int[len];
        for(int i=0;i<len;i++) {
            cut[i] = i+1;
        }

        return knapsack(cut,price,n,len);
        //code here
    }

    static int knapsack(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=W;j++) {
                //recursive function base condition
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                }

                else if (wt[i-1]<=j) {
                    dp[i][j] = Math.max(val[i-1]+ dp[i][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
}
