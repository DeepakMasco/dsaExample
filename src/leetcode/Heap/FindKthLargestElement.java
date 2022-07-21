package leetcode.Heap;

import java.util.PriorityQueue;

/*Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
*/
public class FindKthLargestElement {

    public static void main(String[] args) {
        int [] arr = new int[] {3,2,1,5,6,4};
        int ans = findElement(arr, 2);

        System.out.println(ans);

    }

    private static int findElement(int[] arr, int target) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i : arr) {
            minHeap.add(i);
            if(minHeap.size()>target) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
