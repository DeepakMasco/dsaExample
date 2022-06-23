package slidingWindow.fixed;
/*
* In this we need to find the max sum for any subarray of size K which is given in the question.
* Time Complexity: O(n)
* Auxiliary Space: O(1)
* */
public class SubArrayMaxSum {

    public static void main(String[] args) {

        int[] arr = new int[] {10,20,30,4,5,6};
        int k = 3;
        int size = arr.length;

        int i=0;
        int j=0;
        int sum=0;
        int max=0;

        while(j<size) {
            sum+=arr[j];
            if(j-i+1==k) {
                max= Math.max(sum, max);
                sum -=arr[i];
                i++;
            }
            j++;
        }
        System.out.println(max);
    }
}
