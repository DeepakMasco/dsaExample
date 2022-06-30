package leetcode.dp.knapsack.unbounded;
/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0
*/
public class CoinChangeMinCoins {

    public static void main(String[] args) {
        System.out.println(solve(new int[] {1,2,5},11));
    }

    private static int solve(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];

        // As the no of coins is 0 so we would need infinite no of coins to make this equal to sum. We are doing -1.
        // because in later code we will adding +1 value to this so it can be stored in int otherwise it will fail.
        for(int i=0;i<=sum;i++) {
            dp[0][i] = Integer.MAX_VALUE-1;
        }


        //as sum =0 so we need only 0 coins to make the sum
        for(int i=1;i<=n;i++) {
            dp[i][0] = 0;
        }


        // We need to initialize the 2nd row also. We will be checking how can we achive the sum with the first element.
        // So we first check with % is it possible if yes then we store result if not we store max value
        for(int i=1;i<=sum;i++) {
            if(i%arr[0]!=0) {
                dp[1][i] =  Integer.MAX_VALUE-1;
            } else {
                dp[1][i] = i/arr[0];
            }
        }



        for(int i=2;i<=n;i++) {
            for(int j=1;j<=sum;j++) {

                if(arr[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // In this as we are using unbounded knapsack so we are not decreasing the element if selected.
                    // And we are doing +1 here as we are selecting one coin so we need to maintaing how many coins we selected till now.
                    dp[i][j] = Math.min(
                            dp[i-1][j],
                            1+ dp[i][j-arr[i-1]]
                    );
                }
            }
        }

       /* for(int i=0;i<=n;i++) {
            for(int j=0;j<=sum;j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }*/


        return dp[n][sum]==Integer.MAX_VALUE-1?-1:dp[n][sum];
    }
}
