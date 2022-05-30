package leetcode;

public class Factorial {

    public static void main(String[] args) {

        long input = 20;
        System.out.println(factorial(input));
    }

    public static long factorial(long input) {
        if (input==0) {
            return 1;
        } else {
            return input*factorial(input-1);
        }
    }
}
