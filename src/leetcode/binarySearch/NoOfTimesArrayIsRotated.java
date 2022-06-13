package leetcode.binarySearch;
// The index of min element = the no of times array is rotated
// min element will be surrounded by large elements on left and right side.
public class NoOfTimesArrayIsRotated {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
        int n = noOfRotations(new int[] {4,5,6,7,0,1,2});
        //doing this minus as so that we know the actual rotations .
        System.out.println(Math.min(n, 7-n));
    }

    public static int findMin(int[] arr) {

        int start = 0;
        int end = arr.length-1;
        int n = end+1;

        while(start<=end) {
            int mid = start + (end-start)/2;

            int next = (mid+1)%n;
            int prev = (mid-1)%n;

            if(arr[mid]<=arr[end] && arr[mid]>=arr[start]) {
                return arr[start];
            }
            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]) {
               return arr[mid];
            } else if(arr[mid]>=arr[start]) {
                start = mid +1;
            } else if(arr[mid]<=arr[end]){
                end = mid-1;
            }

        }
        return arr[0];
    }

    public static int noOfRotations(int[] arr) {

        int start = 0;
        int end = arr.length-1;
        int n = end+1;

        while(start<=end) {
            int mid = start + (end-start)/2;

            int next = (mid+1)%n;
            int prev = (mid-1)%n;

            if(arr[mid]<=arr[end] && arr[mid]>=arr[start]) {
                return start;
            }
            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]) {
                return mid;
            } else if(arr[mid]>=arr[start]) {
                start = mid +1;
            } else if(arr[mid]<=arr[end]){
                end = mid-1;
            }

        }
        return 0;
    }
}
