package leetcode;

public class Factorial {

    public static void main(String[] args) {

        int input = 7;
        System.out.println(factorial(input));
    }

    public static int factorial(int input) {
        if (input==0) {
            return 1;
        } else {
            return input*factorial(input-1);
        }
    }
}
