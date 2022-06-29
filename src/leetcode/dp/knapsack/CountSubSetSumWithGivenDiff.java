package leetcode.dp.knapsack;


/*
* You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".

Return the number of different expressions that you can build, which evaluates to target.



Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
*/







/*
*
*
* In this we need to find how many subsets are present in array whose difference is S.
* So we can say Subset1 - subset2 = S
* and we know   Subset1 + Subset2 = totalSum.
* So with this  2*Subset1 = S + TotalSum   -> Subset1 = (S + Totalsum)/2;
* or as we are finding the smallest sum so we can do 2*Subset2 = TotalSum - S -> Subset2 = (Totalsum - S )/2
* we are given S, Totalsum so we can easily find the Sum of subset1.
* And we already did find the count of subsets whose sum is given So we can apply the same logic here and return the count.
*
*
* */
public class CountSubSetSumWithGivenDiff {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[] {1,1,1,1,1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {

        int range = 0;
        for(int i: nums) {
            range+=i;
        }

        // As our sum is divisible by 2 so it should be even so beforehand we can eliminate if range - target is odd.
        if(((range - target) % 2 == 1) || (target > range))
            return 0;
        int sum = (range-target)/2;
        return perfectSum(nums,nums.length,sum);

    }

    public static int perfectSum(int arr[],int n, int sum)
    {
        int[][] dp = new int[n+1][sum+1];


        dp[0][0] = 1;
        for(int i = 1; i <= sum; i++)
            dp[0][i] = 0;

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
