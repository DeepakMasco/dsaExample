package leetcode.dp.knapsack;



/*Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is the same.

Examples:

arr[] = {1, 5, 11, 5}
Output: true
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false
The array cannot be partitioned into equal sum sets.*/


public class EqualSumPartition {

    public static void main(String[] args) {
        int[] input = new int[] {1,5,11,5};
        int sum = 0;
        for(int i: input) {
            sum+=i;
        }


        //We check this condition as we are asked 2 partition of equal sum let us suppose S. so S=S then S+S = 2S and that 2S is sum of array.
        //so with this we know that sum should be even as it is multiple of 2. If it is odd then we can fail fast and return false.
        if(sum%2!=0) {
            System.out.println(false);
        } else {
            System.out.println(solve(input, 4, sum/2));
            System.out.println(solveDp(input, 4, sum/2));
        }

    }


    // in this appraoch we again need to check if the ele>sum then we can either select or reject ir.
    // but if the sum is exceeding then we need to reject only.
    // Here we are doing sum/2 to create the equal sum in 2 partition.
    private static boolean solve(int[] arr, int n, int sum) {
        if(sum==0) {
            return true;
        }
        if(n==0) {
            return false;
        }
        if(arr[n-1]>sum) {
            return  solve(arr,n-1,sum);
        } else {
            return solve(arr,n-1,sum) || solve(arr,n-1,sum-arr[n-1]);
        }
    }

    private static boolean solveDp(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[sum+1][n+1];
        for(int i=0;i<=sum;i++) {
            for(int j=0;j<=n;j++) {
                if(i==0) {
                    dp[i][j] = true;
                }
                else if(j==0) {
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
