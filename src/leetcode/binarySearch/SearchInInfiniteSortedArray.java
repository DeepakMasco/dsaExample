package leetcode.binarySearch;

// We are given a infinite sorted array and we need to find the position of an element.
//In this we can use BS but only one issue we have it we don't know the end of array as it is infinite.
// What we can do is mark high = start+1 and then compare end to key if less end = 2 * end; and then app;y BS
public class SearchInInfiniteSortedArray {


    public static void main(String[] args) {
        System.out.println(findElement(new int[] {4,6,7,9,10}, 4));
        System.out.println(findElement(new int[] {4,6,7,9,10}, 6));
        System.out.println(findElement(new int[] {4,6,7,9,10}, 7));
    }

    private static int findElement(int[] arr, int key) {
        int start = 0;
        int end = 1;

        while(arr[end]<key) {
            start = end;
            end = 2 * end;
        }

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(arr[mid]==key) {
                return mid;
            }
            if(arr[mid]>key) {
                end = mid-1;
            }
            if(arr[mid]<key) {
                start = mid +1;
            }
        }
        return -1;
    }
}
