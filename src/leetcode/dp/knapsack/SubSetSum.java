package leetcode.dp.knapsack;


/*Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.


Example 1:

Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 9
Output: 1
Explanation: Here there exists a subset with
sum = 9, 4+3+2 = 9.
*/
public class SubSetSum {


    public static void main(String[] args) {
        System.out.println(solve(new int[] {3, 34, 4, 12, 5, 2}, 6, 9));
        System.out.println(solveDp(new int[] {3, 34, 4, 12, 5, 2}, 6, 9));
    }


    //recursive solution. As we have option to either choose or not. And if in any one of the case we get true we need to return.
    // Hence we used || operator in the code for return
    static Boolean solve(int[] arr,int n,int sum) {
        if(sum==0){
            return true;
        }
        if(n==0) {
            return false;
        }

        if (arr[n - 1] > sum)
            return solve(arr, n - 1, sum);

        return solve(arr, n-1,sum-arr[n-1]) || solve(arr, n-1,sum);

    }

    static Boolean solveDp(int[] arr,int n,int sum) {

        boolean[][] dp = new boolean[sum+1][n+1];
        for(int i=0;i<=sum;i++) {
            for(int j=0;j<=n;j++){
                if(i==0) {
                    dp[i][j] = true;
                } else if(j==0) {
                    dp[i][j] = false;
                }
                else if(arr[j-1]>i) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1] || dp[i-arr[j-1]][j-1];
                }
            }
        }
        return dp[sum][n];

    }
}
