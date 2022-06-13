package leetcode.binarySearch;

public class FindElementInSortedRotatedArray {

    public static void main(String[] args) {
        int index = findElement(new int[] {4,6,7,9,1,2,3});
        int indexOfTarget = binarySearch(new int[] {4,6,7,9,1,2,3}, 4, index);
        System.out.println(indexOfTarget);
        indexOfTarget = binarySearch(new int[] {4,6,7,9,1,2,3}, 6, index);
        System.out.println(indexOfTarget);
        indexOfTarget = binarySearch(new int[] {4,6,7,9,1,2,3}, 7, index);
        System.out.println(indexOfTarget);
        indexOfTarget = binarySearch(new int[] {4,6,7,9,1,2,3}, 9, index);
        System.out.println(indexOfTarget);
        indexOfTarget = binarySearch(new int[] {4,6,7,9,1,2,3}, 1, index);
        System.out.println(indexOfTarget);
        indexOfTarget = binarySearch(new int[] {4,6,7,9,1,2,3}, 2, index);
        System.out.println(indexOfTarget);
        indexOfTarget = binarySearch(new int[] {4,6,7,9,1,2,3}, 3, index);
        System.out.println(indexOfTarget);
        indexOfTarget = binarySearch(new int[] {4,6,7,9,1,2,3}, 10, index);
        System.out.println(indexOfTarget);
    }

    private static int binarySearch(int[] arr, int target, int minElement) {
        int start = 0;
        int end = minElement;

        if(arr[minElement]<=target && arr[arr.length-1]>=target) {

            start = minElement;
            end = arr.length-1;
        }

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(arr[mid]==target) {
                return mid;
            }
            if(arr[mid]>target) {
                end = mid - 1;
            } else {
                start = mid +1;
            }
        }
        return -1;
    }

    private static int findElement(int[] arr) {

        int start = 0;
        int end = arr.length-1;
        int n = end +1;

        while(start<=end){

            int mid = start + (end-start)/2;
            int next = (mid+1)%n;
            int prev = (mid-1+n)%n;

            if(arr[mid]<=arr[end] && arr[mid]>=arr[start]) {
                return start;
            }
            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]) {
                return mid;
            }
            else if(arr[mid]<=arr[end]) {
                end = mid-1;
            } else if(arr[mid]>=arr[start]){
                start = mid +1;
            }
        }
        return 0;
    }
}
