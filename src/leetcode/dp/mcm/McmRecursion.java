package leetcode.dp.mcm;
/*Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.

The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).

Example 1:

Input: N = 5
arr = {40, 20, 30, 10, 30}
Output: 26000
Explaination: There are 4 matrices of dimension
40x20, 20x30, 30x10, 10x30. Say the matrices are
named as A, B, C, D. Out of all possible combinations,
the most efficient way is (A*(B*C))*D.
The number of operations are -
20*30*10 + 40*20*10 + 40*10*30 = 26000.



In this we know that there will be some pointer in between which will keep sliding from start to end
to create possible solutions for multiply.
So we apply MCM base method. so we need to define i and j. As in arr we know a matrix is like arr[i] = arr[i-1] * arr[i]
it will have all matrix covered but we need to start this loop with i=1 as for i=0 -> i-1 would result in negative index and failure..


so when we define the i and j ->> i = 1 and j = n-1 (n = length of arr)


*/
public class McmRecursion {

    public static void main(String[] args) {
        int[] arr = new int[] {40, 20, 30, 10, 30};
        int n = arr.length;
        System.out.println(solve(arr,1,n-1));
    }

    static int solve(int[] arr, int i, int j) {
        // we make >= as if i and j are equal means there is only one matrix.
        // Hence there will no multiply and cost will be 0 only.
        if(i>=j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int temp = 0;

        //When we break the arr using K there will be 2 calls made.
        //solve(i,k) and solve(k+1,j). This range can vary and we need to verify
        // If we start k from i then in first range we get arr[o] and arr[1]
        // So this will give us one valid matrix.
        // and k=j is also valid as we get one valid matrix.
        // But our range starts from k+1 so we will just keep k<j
        for(int k=i;k<j;k++) {
            // As we already calculated the cost of left and right part./
            // We add them and we need to add the cost of this calc.
            temp = solve(arr,i,k) + solve(arr,k+1,j) + arr[i-1] * arr[k] * arr[j];
            min = Math.min(temp,min);

        }

        return min;
    }
}
