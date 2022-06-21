package leetcode.binarySearch;
/*Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing).

Example 1:

Input:
N = 7, x = 0
arr[] = {1,2,8,10,11,12,19}
Output: -1
Explanation: No element less
than 0 is found. So output
is "-1".

Example 2:

Input:
N = 7, x = 5
arr[] = {1,2,8,10,11,12,19}
Output: 1
Explanation: Largest Number less than 5 is
2 (i.e K = 2), whose index is 1(0-based
indexing).
*/
public class FindFloorValue {

    public static void main(String[] args) {
        System.out.println(getFloorValue(new int[] {1,2,8,10,11,12,19},7,5));
        System.out.println(getCeilingValue(new int[] {1,2,8,10,11,12,19},7,5));
        System.out.println(nextGreatestLetter(new char[] {'c','f','h','k'},'a'));
    }

    private static int getFloorValue(int[] arr, int N, int x) {
        int start = 0;
        int end = N-1;
        int res = -1;
        while(start<=end) {

            int mid = start + (end-start)/2;

            if(arr[mid]==x) {
                return mid;
            }
            if(arr[mid]>x) {
                end = mid-1;
            } if (arr[mid]<x) {
                start = mid+1;
                res = mid;
            }

        }
        return res;
    }

    private static int getCeilingValue(int[] arr, int N, int x) {
        int start = 0;
        int end = N-1;
        int res = -1;
        while(start<=end) {

            int mid = start + (end-start)/2;

            if(arr[mid]==x) {
                return mid;
            }
            if(arr[mid]>x) {
                end = mid-1;
                res = mid;
            } if (arr[mid]<x) {
                start = mid+1;
            }

        }
        return res;
    }


    private static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        char res = '#';

        while(start<=end) {
            int mid = start + (end-start)/2;

            if(letters[mid]==target) {
                start = mid+1;
            }
            if(letters[mid]>target) {
                end = mid -1;
                res = letters[mid];
            } if (letters[mid]<target) {
                start = mid +1;
            }
        }

        return res;
    }
}
