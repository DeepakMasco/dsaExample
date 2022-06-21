package leetcode.binarySearch;


/*  We are given a array with just 0 and 1 and it is sorted but infinite in nature. and we need to find the first occurance of 1
*  For this what we can do is apply this logic to find end from infinite array and then apply BS of first occurance.
* */
public class SearchInBinaryInfiniteSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1};
        int start = 0;
        int end = 1;
        int[] inputs = findEndValue(arr, 1, start, end);
        start = inputs[0];
        end = inputs[1];
        int index = findFirstOccurance(arr,start, end , 1);
        System.out.println(index);
    }

    private static int findFirstOccurance(int[] arr, int start, int end, int key) {
        int res = -1;
        while(start<=end) {
            int mid = start + (end-start)/2;

            if(arr[mid]==key) {
                res = mid;
                end = mid -1;
            }
            if(arr[mid]>key) {
                end = mid -1;
            }
            if(arr[mid]<key){
                start = mid +1;
            }

        }
        return res;
    }

    private static int[] findEndValue(int[] arr, int key, int start, int end) {
        while(key>arr[end]) {
            start = end;
            end = 2 * end;
        }
        return new int[] {start,end};
    }
}
