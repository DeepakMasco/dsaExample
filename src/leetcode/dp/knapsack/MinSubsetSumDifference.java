package leetcode.dp.knapsack;

/*Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference


Example 1:

Input: N = 4, arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11

Example 2:

Input: N = 2, arr[] = {1, 4}
Output: 3
Explanation:
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4



This question is to find S1-S2= min diff. So we know the total sum of arr=range.
 then Range-S1=S2 as S1+S2=Total Sum/Range.
Hence we make it as Range - 2S1 = Min.
Now we need to find what can be the range of the subsets. So we know it can range from 0 to totalSum.
 But from 0 to totalSum all the values cannot be the solution. So what we do is apply the subsetsum problem.
 The last row of the matrix will tell us with all possible values can we achive the sum or not.
 So in last row if value = true then we use that value as S1 to find the min.
 We need to do one more thing. As S1 we are iterating so we can just use half the range of sum. As other half can be easily found by range-S1/
 Hence we make sum/2 +1 for the for loop

 */

public class MinSubsetSumDifference {

    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{1, 6, 11, 5}, 4));
        System.out.println(minDifference(new int[]{1, 4}, 2));
    }

    public static int minDifference(int nums[], int n)
    {
        // Your code goes here

        int range = 0;
        for(int i: nums) {
            range+=i;
        }

        boolean[] rangeOfSum = calculate(nums, n, range);

        int mid = (range/2)+1;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<mid;i++) {
            if(rangeOfSum[i]==true) {
                ans = Math.min(ans, range-2*i);
            }

        }
        return ans;
    }


    private static boolean[] calculate(int[] nums, int n, int sum) {
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=sum;j++){
                if(j==0) {
                    dp[i][j]=true;
                } else if(i==0) {
                    dp[i][j]=false;
                } else if(nums[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        boolean[] range = new boolean[sum+1];
        for(int i=0;i<=sum;i++) {
            range[i]=dp[n][i];
        }
        return range;
    }
}
