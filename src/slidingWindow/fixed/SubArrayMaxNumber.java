package slidingWindow.fixed;

import java.util.ArrayList;
import java.util.List;

/*
* Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

Example 1:

Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output:
3 3 4 5 5 5 6
Explanation:
1st contiguous subarray = {1 2 3} Max = 3
2nd contiguous subarray = {2 3 1} Max = 3
3rd contiguous subarray = {3 1 4} Max = 4
4th contiguous subarray = {1 4 5} Max = 5
5th contiguous subarray = {4 5 2} Max = 5
6th contiguous subarray = {5 2 3} Max = 5
7th contiguous subarray = {2 3 6} Max = 6
*
*
* Time Complexity: O(n)
* Auxiliary Space: O(1)
* */
public class SubArrayMaxNumber {
//TODO - Check the solution if it works correctly.
    public static void main(String[] args) {

        int[] arr = new int[] {-10,20,-30,-4,5,6,8};
        int k = 3;
        int size = arr.length;

        int i=0;
        int j=0;

        List<Integer> maxNumbers = new ArrayList<>();

        while(j<size) {
            if (maxNumbers.isEmpty()) {
                maxNumbers.add(arr[j]);
            }
            else if(arr[j]>maxNumbers.get(0)) {
               maxNumbers.remove(0);
               maxNumbers.add(arr[j]);
            }

            if(j-i+1 == k) {
                System.out.println(maxNumbers.get(0));
                if(maxNumbers.get(0)==arr[i]) {
                    maxNumbers.remove(0);
                }
                i++;
            }

            j++;
        }
    }
}
