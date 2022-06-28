package leetcode.binarySearch;


// We are given a array of size N and numbers are from 1 to N+1. We need to find the missing no in logn time.
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,5,6,7,8,9,10};
        int missingNo = findMissingNo(input);
        System.out.println(missingNo);
    }

    private static int findMissingNo(int[] arr) {
        int size = arr.length+1;
        int low = 0;
        int high = size-1;
        int ans = -1;


        while(low<=high) {
            int mid = low + (high-low)/2;

            if(arr[mid]!= mid+1 && arr[mid-1]==mid) {
                return mid+1;
            }

            if(arr[mid]!=mid+1) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}
