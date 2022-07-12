package leetcode.dp.knapsack.unbounded;


/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.



Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1



This ans is same as subsetsum. Just we need to change the condition of not excluding the element if it is seelcted.
As this is a unbounded knapsack problem.

*/
public class CoinChangeMaximumways {

    public static void main(String[] args) {
        System.out.println(perfectSum(new int[]{1,2,5},3,5));
    }

    public static int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;
        for(int i = 1; i <= sum; i++)
            dp[0][i] = 0;


        // doing rest of the calculation for all the test cases.
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=sum;j++) {
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j]+ dp[i][j-arr[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
}
