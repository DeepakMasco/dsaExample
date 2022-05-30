package leetcode;

public class DivisionWithBit {

    public static void main(String[] args) {
        System.out.println(divide(50,5));
    }

    public static int divide(int A, int B) {
        if (A == Integer.MIN_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        }
        int a = Math.abs(A), b = Math.abs(B), res = 0;
        for (int x = 31; x >= 0; x--)
            if ((a >>> x) - b >= 0) {
                res += 1 << x;
                a -= b << x;
            }
        return (A > 0) == (B > 0) ? res : -res;
    }
}
