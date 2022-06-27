package leetcode.recursion;

public class OneToN {

    public static void main(String[] args) {
        printNumbers(8);
    }

    private static void printNumbers(int i) {
        if(i==0) {
            return;
        }
        System.out.println(i);
        printNumbers(i-1);

    }
}
