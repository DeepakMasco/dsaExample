package leetcode.recursion;

public class TOH {

    public static void main(String[] args) {
        System.out.println(toh(3,1,2,3));
    }

    public static long toh(int N, int from, int to, int aux) {

        if(N==1) {
            System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
            return 1;
        }


        toh(N-1,from, aux, to);
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        toh(N-1,aux,to,from);

        return (long)Math.pow(2, N)-1;
        // Your code here
    }
}
