package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;


/*
* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

*
* */
public class ValidBrackets {

    public static void main(String[] args) {
        int n = 3;
        int open = n;
        int close = n;
        List<String> ans = new ArrayList<>();
        generateBalancedBrackets(open, close, "", ans);
        System.out.println(ans);
    }

    private static void generateBalancedBrackets(int open, int close, String output, List<String> ans) {
        if(open==0 && close==0) {
            ans.add(output);
            return;
        }

        if(open!=0) {
            generateBalancedBrackets(open-1, close, output.concat("("), ans);
        }
        if(close>open) {
            generateBalancedBrackets(open, close-1, output.concat(")"), ans);
        }
    }
}
