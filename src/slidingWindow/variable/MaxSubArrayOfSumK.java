package slidingWindow.variable;

public class MaxSubArrayOfSumK {

    public static void main(String[] args) {

        int[] arr = new int[] {4,1,1,1,2,3,5};
        int sum = 5;
        int tempSum = 0;
        int length = 0;


        int i=0,j=0;

        while(j<arr.length) {
            tempSum+=arr[j];
            if(tempSum==sum) {
                length = Math.max(length,j-i+1);
            } else if(tempSum>sum) {
                tempSum-=arr[i];
                i++;
            }
            j++;
        }

        System.out.println(length);
    }
}
