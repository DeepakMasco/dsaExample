package leetcode.binarySearch;
/*
* We are given a sorted array we need to find the element which gives min difference from the key.
* It means if element is presnet then we should return the same if not we should do - from the neighbour elements
* and then the min one we will return.
*   1,2,3,4,5,8   key = 6
*  6-5 = 1 , 8-6 = 2. Hence ans is 5 as the diff is 1 and this is min,
*
* */
public class FIndMinDifferenceInSortedArray {

    public static void main(String[] args) {
        System.out.println(findMinDiff(new int[] {1,2,3,4,5,8}, 6));
        System.out.println(findMinDiff(new int[] {1,3,8,10,15}, 12));
    }

    private static int findMinDiff(int[] arr, int key) {
        int start = 0;
        int end = arr.length-1;

        while(start<=end) {
            int mid = start + (end-start) / 2;

            if(arr[mid]==key) {
                return arr[mid];
            } if(arr[mid]>key) {
                end = mid -1;
            }
            if(arr[mid]<key) {
                start = mid + 1;
            }
        }
        if(Math.abs(key-arr[start])<Math.abs(key-arr[end])) {
            return arr[start];
        }
        return arr[end];
    }
}
