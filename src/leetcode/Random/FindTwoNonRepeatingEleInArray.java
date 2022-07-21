package leetcode.Random;

public class FindTwoNonRepeatingEleInArray {

    public static void main(String[] args) {
        int[] input = new int[]{5,5,1,1,4,3,4,7};
        //ans should be 3,7 as they only appear once.
        //one way to do this is use HashMap and when frequency =2 remove it
        // and then after loop the elements remains in hashMap is 3,7 but we use N space here
        // 0^5^5^1^1^4^3^4^7 - gives 3^7
        //Now we will divide the group again where

        int result = 0;
        for(int a: input) {
            result = result ^ a;
        }
        // Bitwise & the sum with it's 2's Complement
        // Bitwise & will give us the sum containing
        // only the rightmost set bit
        result = result & -result;


        // sum1 and sum2 will contains 2 unique
        // elements initialized with 0 box
        // number xored with 0 is number itself
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < input.length; i++) {

            // Bitwise & the arr[i] with the sum
            // Two possibilities either result == 0
            // or result > 0
            if ((input[i] & result) > 0) {

                // if result > 0 then arr[i] xored
                // with the sum1
                sum1 = (sum1 ^ input[i]);
            }
            else {
                // if result == 0 then arr[i]
                // xored with sum2
                sum2 = (sum2 ^ input[i]);
            }
        }

        // print the the two unique numbers
        System.out.println("The non-repeating elements are "
                + sum1 + " and " + sum2);
    }
}
