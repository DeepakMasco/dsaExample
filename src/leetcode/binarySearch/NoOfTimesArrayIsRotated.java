package leetcode.binarySearch;
// The index of min element = the no of times array is rotated
// min element will be surrounded by large elements on left and right side.
public class NoOfTimesArrayIsRotated {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3,1}));
        System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
        int n = noOfRotations(new int[] {4,5,6,7,0,1,2});
        //doing this minus as so that we know the actual rotations .
        System.out.println(Math.min(n, 7-n));
    }

    public static int findMin(int[] arr) {

        int n = arr.length;
        int lo=0, hi=n-1;


        while(lo<=hi)
        {
            int mid = lo + ((hi-lo)/2);
            int next = (mid+1)%n;
            int prev = (mid-1+n)%n;
            if(arr[mid]<=arr[hi] && arr[mid]>=arr[lo])
            {
                return arr[lo];
            }
            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev])
            {
                return arr[mid];
            }

            else if(arr[mid]>=arr[lo])
            {
                lo=mid+1;
            }
            else if(arr[mid]<=arr[hi])
            {
                hi=mid-1;
            }
        }
        return arr[0];
    }

    public static int noOfRotations(int[] arr) {

        int n = arr.length;
        int lo=0, hi=n-1;


        while(lo<=hi)
        {
            int mid = lo + ((hi-lo)/2);
            int next = (mid+1)%n;
            int prev = (mid-1+n)%n;
            if(arr[mid]<=arr[hi] && arr[mid]>=arr[lo])
            {
                return lo;
            }
            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev])
            {
                return mid;
            }

            else if(arr[mid]>=arr[lo])
            {
                lo=mid+1;
            }
            else if(arr[mid]<=arr[hi])
            {
                hi=mid-1;
            }
        }
        return 0;
    }
}
