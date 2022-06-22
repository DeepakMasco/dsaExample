package leetcode.Heap;

// In this we need to sort the nearly sorted array of K.
// It means a element will be placed in range of K element from the actual position.


import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void main(String[] args) {
        int[] arr = sortArray(new int[] {6,5,3,2,8,10,9}, 3);
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }

    private static int[] sortArray(int[] arr, int k) {
        int[] result = new int[arr.length];
        int j = 0;
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        for(int i: arr) {
            minPq.add(i);
            if(minPq.size()>k) {
                result[j++] = minPq.poll();
            }
        }
        while(minPq.size()>0) {
            result[j++] = minPq.poll();
        }
        return result;
    }
}
