package leetcode.dp.knapsack;

public class CountSubsetSum {

    public static void main(String[] args) {
        System.out.println(perfectSum(new int[] {3, 34, 4, 12, 5, 2}, 6, 9));
    }


    public static int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        int[][] dp = new int[n+1][sum+1];

        //We are doing this way so that we can include the case of 0 being present in the array.
        // If 0 is not present then we can use the old way we did in subset sum method.

        //if sum and array size both are 0 then we have one solution which is empty set {} hence marking as 1
        dp[0][0] = 1;

        // if we have n=0 and sum>0 then there is no possible solution hence we mark as 0.
        for(int i = 1; i <= sum; i++)
            dp[0][i] = 0;


        // doing rest of the calculation for all the test cases.
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=sum;j++) {
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j]+ dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
}
