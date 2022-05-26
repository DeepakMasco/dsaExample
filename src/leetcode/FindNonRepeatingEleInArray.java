package leetcode;

public class FindNonRepeatingEleInArray {

    public static void main(String[] args) {
        int[] input = new int[]{5,5,1,1,4,3,4};
        //ans should be 3 as it is only appearing once.
        //one way to do this is use HashMap and when frequency =2 remove it and then after loop the element remains in hashMap is 3 but we use N space here
        // 0^5^5^1^1^4^3^4 - gives 3 as 5^5 is zero so all couple will form 0

        int result = 0;
        for(int a: input) {
            result = result ^ a;
        }

        System.out.println(result);
    }
}
