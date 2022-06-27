package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;
/*
* Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. The output should be printed in sorted increasing order of strings

Example 1:

Input:
S = "ABC"
Output: (A_B_C)(A_BC)(AB_C)(ABC)
Explanation:

* It is similar to the all subsequence.
* Just one thing we need to notice is we are adding space after the 1 character.
* So we can add first character in the output and then make a choice on left over char to add the _ or not
* so just change the output and input a bit it turns out to be same problem.
These are the possible combination of "ABC".
* */
public class PermutationWithSpaces {

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String input = "ABC";
        generateWithSpaces(input.substring(1), input.charAt(0)+"", ans);
        System.out.println(ans);
    }

    private static void generateWithSpaces(String input, String output, List<String> ans) {
        if(input.length()==0) {
            ans.add(output);
            return;
        }

        generateWithSpaces(input.substring(1), output+"_"+input.charAt(0), ans);
        generateWithSpaces(input.substring(1), output+input.charAt(0), ans);
    }
}
