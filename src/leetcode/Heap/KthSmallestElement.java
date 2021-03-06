package leetcode.Heap;

/*Given an integer array nums and an integer k, return the kth smallest element in the array.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 2

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 3
*/
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        int [] arr = new int[] {3,2,1,5,6,4};
        int ans = findElement(arr, 2);

        int[] arr1 = new int[] {3,2,3,1,2,4,5,5,6};
        int ans1 = findElement(arr1, 4);

        System.out.println(ans);
        System.out.println(ans1);
    }

    private static int findElement(int[] arr, int target) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : arr) {
            maxPq.add(i);
            if(maxPq.size()>target) {
                maxPq.poll();
            }
        }
        return maxPq.poll();
    }
}
