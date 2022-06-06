package leetcode;


public class FindTrailingZerosInFactorial {

//We cannot calculate the factorial of large no and then count the no of zeros as it will be very long no.
    //what we should do is find the no of 2 and 5 ans 2*5 = 10 means 1 zero
    //two's will be always more than 5. So we need to just find the no of 5 present in the factorial
    public static void main(String[] args) {


        int input = 1200;
        int result = 0;

        for(int i=5;i<=input;i=i*5) {
            result = result + input/i;
        }

        System.out.println(result);

    }
}
