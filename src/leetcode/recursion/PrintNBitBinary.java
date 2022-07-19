package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;


/*Given a positive integer N, the task is to find all the N bit binary numbers
 having more than or equal 1’s than 0’s for any prefix of the number.

Example 1:

Input:  N = 2
Output: 11 10
Explanation: 11 and 10 have more than
or equal 1's than 0's

Example 2:

Input:  N = 3
Output: 111 110 101
Explanation: 111, 110 and 101 have more
than or equal 1's than 0's



We have choice of 1 at every place. But for 0 we can only insert if ones>zeros
so we make 2 choices as coded below
*/

public class PrintNBitBinary {

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        int n = 3;
        int ones = 0;
        int zeros = 0;
        generateBinaryNo(n,ones, zeros, ans,"");
        System.out.println(ans);
    }

    private static void generateBinaryNo(int n, int ones, int zeros, List<String> ans, String output) {
        if(n==0) {
            ans.add(output);
            return;
        }
        // add 1
        generateBinaryNo(n-1,ones+1, zeros, ans,output.concat("1"));
        if(ones>zeros) {
            generateBinaryNo(n-1,ones, zeros+1, ans,output.concat("0"));
        }
    }
}
