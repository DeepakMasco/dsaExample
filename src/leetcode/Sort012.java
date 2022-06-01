package leetcode;

public class Sort012 {
    public static void main(String[] args) {
        int[] input = new int[]{1 ,1 ,1 ,0 ,2 ,2 ,1 ,0};
        with2N(input);
        with1N(input);

    }

    private static void with1N(int[] input) {

        int mid = 0;
        int low = 0;
        int high = input.length-1;
        while(mid<=high) {
            if(input[mid]==0) {
                swap(mid,low,input);
                low++;
                mid++;
            } else if (input[mid]==1) {
                mid++;
            } else {
                swap(mid,high,input);
                high--;
            }
        }

        for(int a: input) {
            System.out.println(a);
        }
    }

    private static void swap(int mid, int low, int[] input) {
        int temp = input[mid];
        input[mid]= input[low];
        input[low] = temp;
    }

    private static void with2N(int[] input) {
        int noOfZero = 0;
        int noOfOnes = 0;

        for(int a: input) {
            if(a==0) noOfZero++;
            else if(a==1) noOfOnes++;
        }

        for(int i = 0; i< input.length; i++){
            int no = 2;
            if(noOfZero!=0) {
                no = 0;
                noOfZero--;
            } else if (noOfOnes!=0) {
                no = 1;
                noOfOnes--;
            }
            input[i] = no;
        }
        for(int a: input) {
           System.out.println(a);
        }
    }
}
